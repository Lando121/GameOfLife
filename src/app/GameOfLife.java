
package app;

public class GameOfLife {
    private static final int GRID_WIDTH = 100;
    private static final int GRID_HEIGHT = 100;
    public static final int WINDOW_WIDTH = 1000;
    public static final int WINDOW_HEIGHT = 1000;
    protected static final int UPDATES_PER_SECOND = 5; //Want to discuss the use of protected for testing purposes

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
