package app.components.grid.renderer;

import java.awt.Color;
import java.awt.Graphics;

import app.Game;
import app.RenderListener;
import app.components.grid.model.Grid;
import app.components.grid.model.LifeEntityState;

public class GridRenderer extends RenderListener{
    private final Grid grid;

    public GridRenderer(Grid grid) {
        this.grid = grid;
    }

    public void render(Graphics g) {
        int gridItemWidth = Game.WINDOW_WIDTH / grid.gridWidth;
        int gridItemHeight = Game.WINDOW_HEIGHT / grid.gridHeight;

        for (int i = 0; i < grid.gridWidth; i++) {
            for (int j = 0; j < grid.gridHeight; j++) {
                if (grid.getLifeEntity(i,j).state == LifeEntityState.ALIVE) {
                    g.setColor(Color.BLACK);
                    g.fillRect(i * gridItemWidth, j * gridItemHeight, gridItemWidth, gridItemHeight);
                }
            }
        }
    }
}