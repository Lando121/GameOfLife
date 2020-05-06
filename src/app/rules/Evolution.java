package app.rules;

import app.utility.LifeEntityState;

public class Evolution {
    public static LifeEntityState aliveStateRule(int aliveNeighbours){
        if (aliveNeighbours >= 2 && aliveNeighbours <= 3) {
            return LifeEntityState.ALIVE;
        }
        return LifeEntityState.DEAD;
    }

    public static LifeEntityState deadStateRule(int aliveNeighbours){
        if (aliveNeighbours == 3) {
            return LifeEntityState.ALIVE;
        }
        return LifeEntityState.DEAD;
    }
}