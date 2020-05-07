package app.components.grid.controller;

import java.util.ArrayList;

import app.UpdateListener;
import app.components.grid.model.Grid;
import app.components.grid.model.LifeEntity;
import app.components.grid.model.LifeEntityState;
import app.rules.Evolution;

public class GridController extends UpdateListener {
    Grid grid;
    private final LifeEntity[][] nextGenerationGrid;

    public GridController(Grid grid) {
        this.grid = grid;
        nextGenerationGrid = new LifeEntity[grid.gridWidth][grid.gridHeight];
        initNextGenerationGrid();
    }

    private void initNextGenerationGrid() {
        for (int i = 0; i < grid.gridWidth; i++) {
            for (int j = 0; j < grid.gridHeight; j++) {
                nextGenerationGrid[i][j] = new LifeEntity(grid.getLifeEntity(i, j));
            }
        }
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
                LifeEntity gridLifeEntity = grid.getLifeEntity(i, j);
                nextGenerationGrid[i][j].state = Evolution.getEvolutionStep(gridLifeEntity.state, aliveNeighbours);
            }
        }
    }

    private void updateGrid(){
        for (int i = 0; i < grid.gridWidth; i++) {
            for (int j = 0; j < grid.gridHeight; j++) {
                grid.getLifeEntity(i, j).state = nextGenerationGrid[i][j].state;
            }
        }
    }

    private int getAmountOfAliveNeighbours(int i, int j) {
        ArrayList<LifeEntity> neighbours = grid.getNeighbours(i, j);
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
}