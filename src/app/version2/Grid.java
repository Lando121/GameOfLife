package app.version2;

import java.util.ArrayList;

public class Grid extends GameObject {
    public static final int GRIDWIDTH = 10;
    public static final int GRIDHEIGHT = 11;
    private LifeEntityState nextState = LifeEntityState.ALIVE;

    public LifeEntity[][] gridOfLifeEntities;

    public Grid() {
        gridOfLifeEntities = new LifeEntity[GRIDWIDTH][GRIDHEIGHT];

        for (int i = 0; i < GRIDWIDTH; i++) {
            for (int j = 0; j < GRIDHEIGHT; j++) {
                gridOfLifeEntities[i][j] = new LifeEntity(nextState);
                if (nextState == LifeEntityState.ALIVE) {
                    nextState = LifeEntityState.DEAD;
                } else {
                    nextState = LifeEntityState.ALIVE;
                }
            }
        }
    }

    @Override
    public void update() {
        System.out.println("updating Grid");
        updateStateOfLifeEntities();
    }

    private void updateStateOfLifeEntities() {
        for (int i = 0; i < GRIDWIDTH; i++) {
            for (int j = 0; j < GRIDHEIGHT; j++) {
                ArrayList<LifeEntity> neighbours = getNeighbours(i, j);
                int aliveNeighbours = getAmountOfAliveNeighbours(neighbours);
                if(aliveNeighbours >= 2 && aliveNeighbours <= 3){
                    getLifeEntity(i, j).setState(LifeEntityState.ALIVE);
                } else {
                    getLifeEntity(i, j).setState(LifeEntityState.DEAD);
                }
            }
        }
    }

    private int getAmountOfAliveNeighbours(ArrayList<LifeEntity> neighbours) {
        int aliveNeighbours = 0;
        for (LifeEntity lifeEntity : neighbours) {
            if (lifeEntity == null) {
                break;
            }
            if (lifeEntity.state == LifeEntityState.ALIVE) {
                aliveNeighbours++;
            }
        }
        return aliveNeighbours;
    }

    private ArrayList<LifeEntity> getNeighbours(int xPosition, int yPosition) {
        ArrayList<LifeEntity> neighbours = new ArrayList<LifeEntity>();

        neighbours.add(getLifeEntity(xPosition - 1, yPosition - 1));
        neighbours.add(getLifeEntity(xPosition - 1, yPosition));
        neighbours.add(getLifeEntity(xPosition - 1, yPosition + 1));
        neighbours.add(getLifeEntity(xPosition, yPosition - 1));
        neighbours.add(getLifeEntity(xPosition, yPosition + 1));
        neighbours.add(getLifeEntity(xPosition + 1, yPosition - 1));
        neighbours.add(getLifeEntity(xPosition + 1, yPosition));
        neighbours.add(getLifeEntity(xPosition + 15, yPosition + 1));

        return neighbours;
    }

    private LifeEntity getLifeEntity(int xPosition, int yPosition) {
        if (xPosition < 0 || xPosition > 9 || yPosition < 0 || yPosition > 10) {
            return null;
        }
        return gridOfLifeEntities[xPosition][yPosition];
    }

    @Override
    public void lateUpdate() {
        // TODO Auto-generated method stub

    }
}