package app.rendering;

import java.awt.Color;
import java.awt.Graphics;

import app.Game;
import app.components.Grid;
import app.models.LifeEntityState;

public class GridRenderer extends RenderListener{
    private final int gridWidth;
    private final int gridHeight;
    private final Grid grid;

    public GridRenderer(int width, int height) {
        gridWidth = width;
        gridHeight = height;
        grid = new Grid(width, height);
    }

    public void render(Graphics g) {
        int gridItemWidth = Game.WINDOW_WIDTH / gridWidth;
        int gridItemHeight = Game.WINDOW_HEIGHT / gridHeight;

        for (int i = 0; i < grid.gridWidth; i++) {
            for (int j = 0; j < grid.gridHeight; j++) {
                if (grid.gridOfLifeEntities[i][j].state == LifeEntityState.ALIVE) {
                    g.setColor(Color.BLACK);
                    g.fillRect(i * gridItemWidth, j * gridItemHeight, gridItemWidth, gridItemHeight);
                }
            }
        }
    }
}