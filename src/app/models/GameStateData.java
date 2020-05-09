package app.models;

import java.util.ArrayList;
import app.utils.EnumUtils;

public class GameStateData {
    private static final String ARGUMENT_EXCEPTION_MESSAGE = "Indicies out of bounds for the grid";

    public final int width;
    public final int height;

    private final LifeState[][] gridOfLifeStates;
    private final GridOffset[] neighbourIndexOffsets = new GridOffset[8];

    public GameStateData(int width, int height) {
        this.width = width;
        this.height = height;
        gridOfLifeStates = new LifeState[width][height];
        initGridOfLifeStates();
        initNeighbourIndexOffsets();
    }

    private void initGridOfLifeStates() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
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

    public ArrayList<LifeState> getNeighbours(int xPosition, int yPosition) {
        if (!isValidArrayPosition(xPosition, yPosition)) {
            throw new IllegalArgumentException(ARGUMENT_EXCEPTION_MESSAGE);
        }

        ArrayList<LifeState> neighbours = new ArrayList<LifeState>();

        for (GridOffset gridOffset : neighbourIndexOffsets) {
            if (!isValidArrayPosition(xPosition + gridOffset.deltaX, yPosition + gridOffset.deltaY)) {
                continue;
            }
            LifeState lifeState = getLifeState(xPosition + gridOffset.deltaX, yPosition + gridOffset.deltaY);
            neighbours.add(lifeState);
        }
        return neighbours;
    }

    public LifeState getLifeState(int xPosition, int yPosition) {
        if (!isValidArrayPosition(xPosition, yPosition)) {
            throw new IllegalArgumentException(ARGUMENT_EXCEPTION_MESSAGE);
        }
        return gridOfLifeStates[xPosition][yPosition];
    }

    public void setLifeState(int xPosition, int yPosition, LifeState state) {
        if (!isValidArrayPosition(xPosition, yPosition)) {
            throw new IllegalArgumentException(ARGUMENT_EXCEPTION_MESSAGE);
        }
        gridOfLifeStates[xPosition][yPosition] = state;
    }

    private boolean isValidArrayPosition(int xPosition, int yPosition) {
        return isValidXPosition(xPosition) && isValidYPosition(yPosition);
    }

    private boolean isValidXPosition(int xPosition) {
        return xPosition >= 0 && xPosition < width;
    }

    private boolean isValidYPosition(int yPosition) {
        return yPosition >= 0 && yPosition < height;
    }

    private class GridOffset {
        int deltaX;
        int deltaY;

        GridOffset(int deltaX, int deltaY) {
            this.deltaX = deltaX;
            this.deltaY = deltaY;
        }
    }
}