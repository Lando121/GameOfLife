package app;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferStrategy;

public class Renderer extends Canvas {
    private BufferStrategy bufferstrategy;
    private Graphics graphics;

    private static final long serialVersionUID = 1L;

    private GameStateData gameStateData;

    public Renderer(GameStateData gameStateData) {
        this.gameStateData = gameStateData;
        new Window(GameOfLife.WINDOW_WIDTH, GameOfLife.WINDOW_HEIGHT, this);
    }

    public void render() {
        setupRendering();
        drawBackground();
        drawGameState();
        finishRendering();
    }

    private void setupRendering() {
        if (bufferstrategy == null) {
            createBufferStrategy(2);
        }
        bufferstrategy = getBufferStrategy();

        graphics = bufferstrategy.getDrawGraphics();
    }

    private void drawBackground() {
        graphics.setColor(Color.white);
        graphics.fillRect(0, 0, getWidth(), getHeight());
    }

    private void drawGameState() {
        int gridItemWidth = GameOfLife.WINDOW_WIDTH / GameOfLife.GRID_WIDTH;
        int gridItemHeight = GameOfLife.WINDOW_HEIGHT / GameOfLife.GRID_HEIGHT;

        for (int i = 0; i < GameOfLife.GRID_WIDTH; i++) {
            for (int j = 0; j < GameOfLife.GRID_HEIGHT; j++) {
                if (gameStateData.getLifeState(i,j) == LifeState.ALIVE) {
                    graphics.setColor(Color.BLACK);
                    graphics.fillRect(i * gridItemWidth, j * gridItemHeight, gridItemWidth, gridItemHeight);
                }
            }
        }
    }

    private void finishRendering() {
        graphics.dispose();
        bufferstrategy.show();
    }
}