package app.rendering;

import java.awt.Color;
import java.awt.Graphics;

import app.game_logic.LifeEntityState;
import app.game_logic.game_objects.Grid;
import app.game_logic.game_objects.LifeEntity;

public class GridRenderer {

    private Grid grid;

    GridRenderer() {
        grid = new Grid();
    }

    public void render(Graphics g) {
        int gridItemWidth = GameWindow.WIDTH / Grid.GRIDWIDTH;
        int gridItemHeight = GameWindow.HEIGHT / Grid.GRIDHEIGHT;
        int x = 0;
        int y = 0;

        for (LifeEntity[] row : grid.gridOfLifeEntities) {
            for (LifeEntity lifeEntity : row) {
                if (lifeEntity.state == LifeEntityState.ALIVE) {
                    g.setColor(Color.BLACK);
                    g.fillRect(x, y, gridItemWidth, gridItemHeight);
                }
                y += gridItemHeight;
            }
            y = 0;
            x += gridItemWidth;
        }
    }
}