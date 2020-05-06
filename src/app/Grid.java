package app;

import java.util.ArrayList;

public class Grid extends GameObject {
    public static final int GRIDWIDTH = 100;
    public static final int GRIDHEIGHT = 100;

    public LifeEntity[][] gridOfLifeEntities;
    private LifeEntity[][] previousGridOfLifeEntities;

    public Grid() {
        gridOfLifeEntities = new LifeEntity[GRIDWIDTH][GRIDHEIGHT];
        previousGridOfLifeEntities = new LifeEntity[GRIDWIDTH][GRIDHEIGHT];

        for (int i = 0; i < GRIDWIDTH; i++) {
            for (int j = 0; j < GRIDHEIGHT; j++) {
                LifeEntityState state = Utils.randomEnum(LifeEntityState.class);
                gridOfLifeEntities[i][j] = new LifeEntity(state);
            }
        }
    }

    @Override
    public void update() {
        setupPreviousGridOfLifeEntities();
        updateStateOfLifeEntities();
    }

    private void setupPreviousGridOfLifeEntities() {
        for (int i = 0; i < GRIDWIDTH; i++) {
            for (int j = 0; j < GRIDHEIGHT; j++) {
                LifeEntity copy = gridOfLifeEntities[i][j].clone();
                previousGridOfLifeEntities[i][j] = copy;
            }
        }
    }

    private void updateStateOfLifeEntities() {
        for (int i = 0; i < GRIDWIDTH; i++) {
            for (int j = 0; j < GRIDHEIGHT; j++) {
                ArrayList<LifeEntity> neighbours = getNeighbours(i, j);
                int aliveNeighbours = getAmountOfAliveNeighbours(neighbours);
                if (gridOfLifeEntities[i][j].state == LifeEntityState.ALIVE) {
                    if (aliveNeighbours >= 2 && aliveNeighbours <= 3) {
                        getLifeEntity(i, j).setState(LifeEntityState.ALIVE);
                    } else {
                        getLifeEntity(i, j).setState(LifeEntityState.DEAD);
                    }
                } else {
                    if(aliveNeighbours == 3){
                        getLifeEntity(i, j).setState(LifeEntityState.ALIVE);
                    }
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

        neighbours.add(getPreviousLifeEntity(xPosition - 1, yPosition - 1));
        neighbours.add(getPreviousLifeEntity(xPosition - 1, yPosition));
        neighbours.add(getPreviousLifeEntity(xPosition - 1, yPosition + 1));
        neighbours.add(getPreviousLifeEntity(xPosition, yPosition - 1));
        neighbours.add(getPreviousLifeEntity(xPosition, yPosition + 1));
        neighbours.add(getPreviousLifeEntity(xPosition + 1, yPosition - 1));
        neighbours.add(getPreviousLifeEntity(xPosition + 1, yPosition));
        neighbours.add(getPreviousLifeEntity(xPosition + 1, yPosition + 1));

        return neighbours;
    }

    private LifeEntity getLifeEntity(int xPosition, int yPosition) {
        if (inValidArrayPosition(xPosition, yPosition)) {
            return null;
        }
        return gridOfLifeEntities[xPosition][yPosition];
    }

    private LifeEntity getPreviousLifeEntity(int xPosition, int yPosition) {
        if (inValidArrayPosition(xPosition, yPosition)) {
            return null;
        }
        return previousGridOfLifeEntities[xPosition][yPosition];
    }

    private boolean inValidArrayPosition(int xPosition, int yPosition) {
        return (xPosition < 0 || xPosition >= GRIDWIDTH || yPosition < 0 || yPosition >= GRIDHEIGHT);
    }

    @Override
    public void lateUpdate() {

    }
}