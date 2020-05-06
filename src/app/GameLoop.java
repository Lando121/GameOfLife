package app;

import java.util.ArrayList;
import java.util.List;

import app.components.UpdateListener;
import app.rendering.RenderListener;
import app.rendering.Renderer;

public class GameLoop {
    private boolean isRunning = true;
    private long lastUpdateTime;
    private long currentTime;
    private static final int FPS = 5;

    private static List<UpdateListener> updateListeners = new ArrayList<>();
    private static Renderer renderer;

    GameLoop() {
        renderer = new Renderer();
    }

    public static void addRenderListener(RenderListener renderObject) {
        renderer.addRenderListener(renderObject);
    }

    public static void removeRenderListener(RenderListener renderObject) {
        renderer.removeRenderListener(renderObject);
    }

    public static void addUpdateListener(UpdateListener gameObject) {
        updateListeners.add(gameObject);
    }

    public static void removeUpdateListener(UpdateListener gameObject) {
        updateListeners.remove(gameObject);
    }

    public void start() {
        lastUpdateTime = System.currentTimeMillis();

        while (isRunning) {
            currentTime = System.currentTimeMillis();

            if (shouldUpdateGame()) {
                lastUpdateTime = System.currentTimeMillis();
                update();
                renderer.render();
            }
        }
    }

    private boolean shouldUpdateGame() {
        return currentTime - lastUpdateTime > 1000 / FPS;
    }

    private void update() {
        for (UpdateListener updateListener : updateListeners) {
            if (updateListener != null) {
                updateListener.update();
            }
        }
    }
}