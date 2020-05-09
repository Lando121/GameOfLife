package app.logic;

import app.models.LifeState;

public class Evolution {
    private static final String ILLEGAL_ARGUMENT_MESSAGE = "Negative amount of alive neighbours is not allowed";

    public static LifeState getNextGenerationState(LifeState currentState, int aliveNeighbours) {
        if (aliveNeighbours < 0) {
            throw new IllegalArgumentException(ILLEGAL_ARGUMENT_MESSAGE);
        }

        if (currentState == LifeState.ALIVE) {
            return aliveStateRule(aliveNeighbours);
        }
        return deadStateRule(aliveNeighbours);
    }

    private static LifeState aliveStateRule(int aliveNeighbours) {
        if (aliveNeighbours >= 2 && aliveNeighbours <= 3) {
            return LifeState.ALIVE;
        }
        return LifeState.DEAD;
    }

    private static LifeState deadStateRule(int aliveNeighbours) {
        if (aliveNeighbours == 3) {
            return LifeState.ALIVE;
        }
        return LifeState.DEAD;
    }
}