package app.components;

import app.components.grid.controller.GridController;
import app.components.grid.model.Grid;
import app.components.grid.renderer.GridRenderer;

public class GridComponent {
    Grid grid;
    GridRenderer gridRenderer;
    GridController gridController;
    
    public GridComponent(int width, int height){
        grid = new Grid(width, height);
        gridRenderer = new GridRenderer(grid);
        gridController = new GridController(grid);
    }
}