package app.rules;

import app.components.grid.model.LifeState;

public class Evolution {

    public static LifeState getEvolutionStep(LifeState currentState, int aliveNeighbours) throws IllegalArgumentException {
        if(aliveNeighbours < 0){
            throw new IllegalArgumentException();
        }

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