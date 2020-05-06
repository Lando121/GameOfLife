package app.components;

import java.util.ArrayList;

import app.utility.*;
import app.rules.*;

public class Grid extends GameObject {
    public static final int GRIDWIDTH = 100;
    public static final int GRIDHEIGHT = 100;

    public LifeEntity[][] gridOfLifeEntities = new LifeEntity[GRIDWIDTH][GRIDHEIGHT];
    private LifeEntity[][] cachedGridOfLifeEntities = new LifeEntity[GRIDWIDTH][GRIDHEIGHT];
    private GridOffset[] neighbourIndexOffsets = new GridOffset[8];

    public Grid() {
        initGridOfLifeEntities();
        initNeighbourIndexOffsets();
    }

    private void initGridOfLifeEntities() {
        for (int i = 0; i < GRIDWIDTH; i++) {
            for (int j = 0; j < GRIDHEIGHT; j++) {
                LifeEntityState state = EnumUtils.randomEnum(LifeEntityState.class);
                gridOfLifeEntities[i][j] = new LifeEntity(state);
            }
        }
    }

    private void initNeighbourIndexOffsets() {
        neighbourIndexOffsets[0] = new GridOffset(-1, -1);
        neighbourIndexOffsets[1] = new GridOffset(-1, 0);
        neighbourIndexOffsets[2] = new GridOffset(-1, 1);
        neighbourIndexOffsets[3] = new GridOffset(0, -1);
        neighbourIndexOffsets[4] = new GridOffset(0, 1);
        neighbourIndexOffsets[5] = new GridOffset(1, -1);
        neighbourIndexOffsets[6] = new GridOffset(1, 0);
        neighbourIndexOffsets[7] = new GridOffset(1, 1);
    }

    @Override
    public void update() {
        cacheCurrentStateOfLifeEntities();
        performEvolutionOnLifeEntities();
    }

    private void cacheCurrentStateOfLifeEntities() {
        for (int i = 0; i < GRIDWIDTH; i++) {
            for (int j = 0; j < GRIDHEIGHT; j++) {
                LifeEntity copy = new LifeEntity(gridOfLifeEntities[i][j]);
                cachedGridOfLifeEntities[i][j] = copy;
            }
        }
    }

    private void performEvolutionOnLifeEntities() {
        for (int i = 0; i < GRIDWIDTH; i++) {
            for (int j = 0; j < GRIDHEIGHT; j++) {
                LifeEntity currentLifeEntity = getLifeEntity(i, j);
                ArrayList<LifeEntity> neighbours = getNeighbours(i, j);
                int aliveNeighbours = getAmountOfAliveNeighbours(neighbours);
                currentLifeEntity.state = getNextGenerationLifeEntityState(currentLifeEntity.state, aliveNeighbours);
            }
        }
    }

    private ArrayList<LifeEntity> getNeighbours(int xPosition, int yPosition) {
        ArrayList<LifeEntity> neighbours = new ArrayList<LifeEntity>();

        for (GridOffset gridOffset : neighbourIndexOffsets) {
            LifeEntity lifeEntity = getCachedLifeEntity(xPosition + gridOffset.x, yPosition + gridOffset.y);
            if (lifeEntity != null) {
                neighbours.add(lifeEntity);
            }
        }
        return neighbours;
    }

    private LifeEntity getCachedLifeEntity(int xPosition, int yPosition) {
        if (inValidArrayPosition(xPosition, yPosition)) {
            return null;
        }
        return cachedGridOfLifeEntities[xPosition][yPosition];
    }

    private boolean inValidArrayPosition(int xPosition, int yPosition) {
        return (xPosition < 0 || xPosition >= GRIDWIDTH || yPosition < 0 || yPosition >= GRIDHEIGHT);
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

    private LifeEntity getLifeEntity(int xPosition, int yPosition) {
        if (inValidArrayPosition(xPosition, yPosition)) {
            return null;
        }
        return gridOfLifeEntities[xPosition][yPosition];
    }

    private LifeEntityState getNextGenerationLifeEntityState(LifeEntityState currentState, int aliveNeighbours) {
        if (currentState == LifeEntityState.ALIVE) {
            return Evolution.aliveStateRule(aliveNeighbours);
        }
        return Evolution.deadStateRule(aliveNeighbours);
    }

    private class GridOffset {
        int x;
        int y;

        GridOffset(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}