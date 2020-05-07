package app;

import java.util.ArrayList;
import java.util.List;

import app.rendering.Renderer;

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

    public void stop(){
        isRunning = false;
    }

    private boolean shouldUpdateGame() {
        return currentTime - lastUpdateTime > 1000 / UPDATES_PER_SECOND;
    }
}