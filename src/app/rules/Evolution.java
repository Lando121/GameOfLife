package app.rules;

import app.components.grid.model.LifeState;

public class Evolution {

    public static LifeState getEvolutionStep(LifeState currentState, int aliveNeighbours){
        if(currentState == LifeState.ALIVE){
            return aliveStateRule(aliveNeighbours);
        }
        return deadStateRule(aliveNeighbours);
    }

    private static LifeState aliveStateRule(int aliveNeighbours){
        if (aliveNeighbours >= 2 && aliveNeighbours <= 3) {
            return LifeState.ALIVE;
        }
        return LifeState.DEAD;
    }

    private static LifeState deadStateRule(int aliveNeighbours){
        if (aliveNeighbours == 3) {
            return LifeState.ALIVE;
        }
        return LifeState.DEAD;
    }
}