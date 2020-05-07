package app;

import java.util.ArrayList;

public class LogicSystem {
    private final LifeState[][] nextGenerationState;
    private GameStateData gameStateData;

    public LogicSystem(GameStateData gameStateData){
        this.gameStateData = gameStateData;
        nextGenerationState = new LifeState[gameStateData.width][gameStateData.height];
    }

    public void update(){
        generateNextGenerationState();
        updateGameState();
    }

    private void generateNextGenerationState() {
        for (int i = 0; i < gameStateData.width; i++) {
            for (int j = 0; j < gameStateData.height; j++) {
                int aliveNeighbours = getAmountOfAliveNeighbours(i, j);
                LifeState lifeState = gameStateData.getLifeState(i, j);
                nextGenerationState[i][j] = Evolution.getNextGenerationState(lifeState, aliveNeighbours);
            }
        }
    }

    private void updateGameState(){
        for (int i = 0; i < gameStateData.width; i++) {
            for (int j = 0; j < gameStateData.height; j++) {
                gameStateData.setLifeState(i, j, nextGenerationState[i][j]);
            }
        }
    }

    private int getAmountOfAliveNeighbours(int i, int j) {
        ArrayList<LifeState> neighbours = gameStateData.getNeighbours(i, j);
        int aliveNeighbours = 0;
        for (LifeState lifeState : neighbours) {
            if (lifeState == LifeState.ALIVE) {
                aliveNeighbours++;
            }
        }
        return aliveNeighbours;
    }
}