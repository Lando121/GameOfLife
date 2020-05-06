
package app;

import java.util.ArrayList;
import java.util.List;

import app.components.GameObject;
import app.rendering.GridRenderer;
import app.rendering.RenderObject;
import app.rendering.Window;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferStrategy;

public class Game extends Canvas  {
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 1000;
    private static final String TITLE = "GameOfLife";

    private long lastLoopTime = System.currentTimeMillis();
    private long currentTime;

    private static final long serialVersionUID = 1L;

    private static List<GameObject> gameObjects = new ArrayList<>();
    private static List<RenderObject> renderObjects = new ArrayList<>();

    private static final int FPS = 5;
    private final boolean isRunning = true;

    public static void main(final String args[]) {
        new Game();
    }

    public static void addUpdateListener(final GameObject gameObject) {
        gameObjects.add(gameObject);
    }

    public static void removeRenderListener(final GameObject gameObject) {
        gameObjects.remove(gameObject);
    }

    public static void addRenderListener(final RenderObject renderObject) {
        renderObjects.add(renderObject);
    }

    public static void removeRenderListener(final RenderObject renderObject) {
        renderObjects.remove(renderObject);
    }

    Game() {
        final Window window = new Window(WIDTH, HEIGHT, TITLE, this);
        new GridRenderer();
        runGameLoop();
    }

    public void runGameLoop() {
        while (isRunning) {
            currentTime = System.currentTimeMillis();

            if (currentTime - lastLoopTime > 1000 / FPS) {
                lastLoopTime = System.currentTimeMillis();
                update();
                render();
            }
        }
    }

    private void update() {
        for (final GameObject gameObject : gameObjects) {
            gameObject.update();
        }
    }

    private void render() {
        final BufferStrategy bufferstrategy = getBufferStrategy();

        if (bufferstrategy == null) {
            createBufferStrategy(3);
            return;
        }

        final Graphics g = bufferstrategy.getDrawGraphics();

        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());

        for (final RenderObject renderObject : renderObjects) {
            renderObject.render(g);
        }

        g.dispose();
        bufferstrategy.show();
    }
}
