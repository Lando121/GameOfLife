package app;

public class GameLoop {
    private Game game; 
    private boolean isRunning;
    private long lastUpdateTime;
    private long currentTime;
    private static final int UPDATES_PER_SECOND = 5;

    public GameLoop(Game game) {
        this.game = game;
    }

    public void start() {
        lastUpdateTime = System.currentTimeMillis();
        isRunning = true;
        while (isRunning) {
            currentTime = System.currentTimeMillis();

            if (shouldUpdateGame()) {
                lastUpdateTime = System.currentTimeMillis();
                game.updateGame();
            }
            game.renderGame();
        }
    }

    private boolean shouldUpdateGame() {
        return currentTime - lastUpdateTime > 1000 / UPDATES_PER_SECOND;
    }
}