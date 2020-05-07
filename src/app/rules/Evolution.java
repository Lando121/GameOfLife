package app.rules;

import app.components.grid.model.LifeEntityState;

public class Evolution {

    public static LifeEntityState getEvolutionStep(LifeEntityState currentState, int aliveNeighbours){
        if(currentState == LifeEntityState.ALIVE){
            return aliveStateRule(aliveNeighbours);
        }
        return deadStateRule(aliveNeighbours);
    }

    private static LifeEntityState aliveStateRule(int aliveNeighbours){
        if (aliveNeighbours >= 2 && aliveNeighbours <= 3) {
            return LifeEntityState.ALIVE;
        }
        return LifeEntityState.DEAD;
    }

    private static LifeEntityState deadStateRule(int aliveNeighbours){
        if (aliveNeighbours == 3) {
            return LifeEntityState.ALIVE;
        }
        return LifeEntityState.DEAD;
    }
}