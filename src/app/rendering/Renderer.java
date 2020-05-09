package app.rendering;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferStrategy;

import app.GameOfLife;
import app.models.GameStateData;
import app.models.LifeState;

public class Renderer extends Canvas {
    private static final long serialVersionUID = 1L;
    private BufferStrategy bufferstrategy;
    private Graphics graphics;
    private int windowWidth;
    private int windowHeight;
    private int gridItemSize;
    private GameStateData gameStateData;

    public Renderer(GameStateData gameStateData) {
        this.gameStateData = gameStateData;
        gridItemSize = getGridItemSize();
        setWindowBounds();
        new Window(windowWidth, windowHeight, this);
    }

    private int getGridItemSize(){
        return Math.min(GameOfLife.MAX_WINDOW_SIZE / gameStateData.width, GameOfLife.MAX_WINDOW_SIZE / gameStateData.height);
    }

    private void setWindowBounds(){
        windowWidth = gridItemSize * gameStateData.width;
        windowHeight = gridItemSize * gameStateData.height;
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
        for (int i = 0; i < gameStateData.width; i++) {
            for (int j = 0; j < gameStateData.height; j++) {
                if (gameStateData.getLifeState(i,j) == LifeState.ALIVE) {
                    graphics.setColor(Color.BLACK);
                    graphics.fillRect(i * gridItemSize, j * gridItemSize, gridItemSize, gridItemSize);
                }
            }
        }
    }

    private void finishRendering() {
        graphics.dispose();
        bufferstrategy.show();
    }
}