package app.components.grid.model;

import java.util.ArrayList;
import app.utility.*;

public class Grid {
    public final int gridWidth;
    public final int gridHeight;

    private final LifeState[][] gridOfLifeStates;
    private final GridOffset[] neighbourIndexOffsets = new GridOffset[8];

    public Grid(int width, int height) {
        gridWidth = width;
        gridHeight = height;
        gridOfLifeStates = new LifeState[gridWidth][gridHeight];
        initGridOfLifeStates();
        initNeighbourIndexOffsets();
    }

    private void initGridOfLifeStates() {
        for (int i = 0; i < gridWidth; i++) {
            for (int j = 0; j < gridHeight; j++) {
                gridOfLifeStates[i][j] = EnumUtils.randomEnum(LifeState.class);
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

    public ArrayList<LifeState> getNeighbours(int xPosition, int yPosition) throws IllegalArgumentException {
        if (invalidArrayPosition(xPosition, yPosition)) {
            throw new IllegalArgumentException();
        }
        ArrayList<LifeState> neighbours = new ArrayList<LifeState>();

        for (GridOffset gridOffset : neighbourIndexOffsets) {
            if (invalidArrayPosition(xPosition + gridOffset.x, yPosition + gridOffset.y)) {
                continue;
            }
            LifeState lifeState = getLifeState(xPosition + gridOffset.x, yPosition + gridOffset.y);
            neighbours.add(lifeState);
        }
        return neighbours;
    }

    public LifeState getLifeState(int xPosition, int yPosition) throws IllegalArgumentException {
        if (invalidArrayPosition(xPosition, yPosition)) {
            throw new IllegalArgumentException();
        }
        return gridOfLifeStates[xPosition][yPosition];
    }

    public void setLifeState(int xPosition, int yPosition, LifeState state) throws IllegalArgumentException {
        if (invalidArrayPosition(xPosition, yPosition)) {
            throw new IllegalArgumentException();
        }
        gridOfLifeStates[xPosition][yPosition] = state;
    }

    private boolean invalidArrayPosition(int xPosition, int yPosition) {
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