
package app;

import app.logic.LogicSystem;
import app.models.GameStateData;
import app.rendering.Renderer;

public class GameOfLife {
    public static final int MAX_WINDOW_SIZE = 1000;
    protected static final int UPDATES_PER_SECOND = 5;
    private static final int GRID_WIDTH = 200;
    private static final int GRID_HEIGHT = 100;

    private boolean isRunning;
    private long lastUpdateTime;
    private long currentTime;

    private LogicSystem logicSystem;
    private GameStateData gameStateData;
    private Renderer renderer;

    public static void main(final String args[]) {
        new GameOfLife().run();
    }

    public GameOfLife() {
        setupGame();
    }

    private void setupGame() {
        gameStateData = new GameStateData(GRID_WIDTH, GRID_HEIGHT);
        logicSystem = new LogicSystem(gameStateData);
        renderer = new Renderer(gameStateData);
    }

    public void run() {
        lastUpdateTime = System.currentTimeMillis();
        isRunning = true;
        while (isRunning) {
            currentTime = System.currentTimeMillis();

            if (shouldUpdateGame()) {
                lastUpdateTime = System.currentTimeMillis();
                updateGame();
            }
            renderGame();
        }
    }

    public void stop(){
        isRunning = false;
    }

    private boolean shouldUpdateGame() {
        return currentTime - lastUpdateTime > 1000 / UPDATES_PER_SECOND;
    }

    protected void updateGame() {
        logicSystem.update();
    }

    protected void renderGame() {
        renderer.render();
    }
}
