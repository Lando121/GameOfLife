package app.components;

import java.util.ArrayList;

import app.utility.EnumUtils;
import app.models.*;
import app.rules.Evolution;

public class Grid extends UpdateListener {
    public final int gridWidth;
    public final int gridHeight;

    public final LifeEntity[][] gridOfLifeEntities;
    private final LifeEntity[][] cachedGridOfLifeEntities;
    private final GridOffset[] neighbourIndexOffsets = new GridOffset[8];

    public Grid(int width, int height) {
        gridWidth = width;
        gridHeight = height;
        gridOfLifeEntities = new LifeEntity[gridWidth][gridHeight];
        cachedGridOfLifeEntities = new LifeEntity[gridWidth][gridHeight];
        initGridOfLifeEntities();
        initCachedGridOfLifeEntities();
        initNeighbourIndexOffsets();
    }

    private void initGridOfLifeEntities() {
        for (int i = 0; i < gridWidth; i++) {
            for (int j = 0; j < gridHeight; j++) {
                LifeEntityState state = EnumUtils.randomEnum(LifeEntityState.class);
                gridOfLifeEntities[i][j] = new LifeEntity(state);
            }
        }
    }

    private void initCachedGridOfLifeEntities() {
        for (int i = 0; i < gridWidth; i++) {
            for (int j = 0; j < gridHeight; j++) {
                cachedGridOfLifeEntities[i][j] = new LifeEntity(gridOfLifeEntities[i][j]);
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
        for (int i = 0; i < gridWidth; i++) {
            for (int j = 0; j < gridHeight; j++) {
                cachedGridOfLifeEntities[i][j].state = gridOfLifeEntities[i][j].state;
            }
        }
    }

    private void performEvolutionOnLifeEntities() {
        for (int i = 0; i < gridWidth; i++) {
            for (int j = 0; j < gridHeight; j++) {
                int aliveNeighbours = getAmountOfAliveNeighbours(i, j);
                LifeEntity currentLifeEntity = getLifeEntity(i, j);
                currentLifeEntity.state = Evolution.evolve(currentLifeEntity.state, aliveNeighbours);
            }
        }
    }

    private int getAmountOfAliveNeighbours(int i, int j) {
        ArrayList<LifeEntity> neighbours = getNeighbours(i, j);
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
        return (xPosition < 0 || xPosition >= gridWidth || yPosition < 0 || yPosition >= gridHeight);
    }

    private LifeEntity getLifeEntity(int xPosition, int yPosition) {
        if (inValidArrayPosition(xPosition, yPosition)) {
            return null;
        }
        return gridOfLifeEntities[xPosition][yPosition];
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