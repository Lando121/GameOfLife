package app.components.grid.model;

import java.util.ArrayList;
import app.utility.*;

public class Grid {
    public final int gridWidth;
    public final int gridHeight;

    private final LifeEntity[][] gridOfLifeEntities;
    private final GridOffset[] neighbourIndexOffsets = new GridOffset[8];

    public Grid(int width, int height) {
        gridWidth = width;
        gridHeight = height;
        gridOfLifeEntities = new LifeEntity[gridWidth][gridHeight];
        initGridOfLifeEntities();
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

    public ArrayList<LifeEntity> getNeighbours(int xPosition, int yPosition) {
        ArrayList<LifeEntity> neighbours = new ArrayList<LifeEntity>();

        for (GridOffset gridOffset : neighbourIndexOffsets) {
            LifeEntity lifeEntity = getLifeEntity(xPosition + gridOffset.x, yPosition + gridOffset.y);
            if (lifeEntity != null) {
                neighbours.add(lifeEntity);
            }
        }
        return neighbours;
    }

    public LifeEntity getLifeEntity(int xPosition, int yPosition) {
        if (inValidArrayPosition(xPosition, yPosition)) {
            return null;
        }
        return gridOfLifeEntities[xPosition][yPosition];
    }

    private boolean inValidArrayPosition(int xPosition, int yPosition) {
        return (xPosition < 0 || xPosition >= gridWidth || yPosition < 0 || yPosition >= gridHeight);
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