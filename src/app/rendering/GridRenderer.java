package app.rendering;

import java.awt.Color;
import java.awt.Graphics;

import app.Game;
import app.components.Grid;
import app.utility.*;

public class GridRenderer extends RenderObject{

    private Grid grid;

    public GridRenderer() {
        grid = new Grid();
    }

    public void render(Graphics g) {
        int gridItemWidth = Game.WIDTH / Grid.GRIDWIDTH;
        int gridItemHeight = Game.HEIGHT / Grid.GRIDHEIGHT;

        for (int i = 0; i < Grid.GRIDWIDTH; i++) {
            for (int j = 0; j < Grid.GRIDHEIGHT; j++) {
                if (grid.gridOfLifeEntities[i][j].state == LifeEntityState.ALIVE) {
                    g.setColor(Color.BLACK);
                    g.fillRect(i * gridItemWidth, j * gridItemHeight, gridItemWidth, gridItemHeight);
                }
            }
        }
    }
}