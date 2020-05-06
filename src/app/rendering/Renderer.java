package app.rendering;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import app.Game;

public class Renderer extends Canvas {
    private BufferStrategy bufferstrategy;
    private Graphics graphics;

    private List<RenderListener> renderListeners = new ArrayList<>();

    private static final long serialVersionUID = 1L;

    public Renderer() {
        new Window(Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT, Game.GAME_TITLE, this);
    }

    public void addRenderListener(RenderListener renderListener) {
        renderListeners.add(renderListener);
    }

    public void removeRenderListener(RenderListener renderObject) {
        renderListeners.remove(renderObject);
    }

    public void render() {
        setupRendering();
        drawBackground();
        drawRenderObjects();
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

    private void drawRenderObjects() {
        for (RenderListener renderListener : renderListeners) {
            if (renderListener != null) {
                renderListener.render(graphics);
            }
        }
    }

    private void finishRendering(){
        graphics.dispose();
        bufferstrategy.show();
    }
}