package app.components.grid.controller;

import java.util.ArrayList;

import app.UpdateListener;
import app.components.grid.model.Grid;
import app.components.grid.model.LifeState;

public class GridController extends UpdateListener {
    Grid grid;
    private final LifeState[][] nextGenerationGrid;

    public GridController(Grid grid) {
        this.grid = grid;
        nextGenerationGrid = new LifeState[grid.gridWidth][grid.gridHeight];
    }

    @Override
    public void update() {
        performEvolutionOnLifeEntities();
        updateGrid();
    }

    private void performEvolutionOnLifeEntities() {
        for (int i = 0; i < grid.gridWidth; i++) {
            for (int j = 0; j < grid.gridHeight; j++) {
                int aliveNeighbours = getAmountOfAliveNeighbours(i, j);
                LifeState lifeState = grid.getLifeState(i, j);
                nextGenerationGrid[i][j] = Evolution.getNextGenerationState(lifeState, aliveNeighbours);
            }
        }
    }

    private void updateGrid(){
        for (int i = 0; i < grid.gridWidth; i++) {
            for (int j = 0; j < grid.gridHeight; j++) {
                grid.setLifeState(i, j, nextGenerationGrid[i][j]);
            }
        }
    }

    private int getAmountOfAliveNeighbours(int i, int j) {
        ArrayList<LifeState> neighbours = grid.getNeighbours(i, j);
        int aliveNeighbours = 0;
        for (LifeState lifeState : neighbours) {
            if (lifeState == LifeState.ALIVE) {
                aliveNeighbours++;
            }
        }
        return aliveNeighbours;
    }
}