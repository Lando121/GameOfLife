
package app;

import app.rendering.GridRenderer;

public class Game {
    private final int GRID_WIDTH = 100;
    private final int GRID_HEIGHT = 100; 
    public static int WINDOW_WIDTH = 1000;
    public static int WINDOW_HEIGHT = 1000;
    public static final String GAME_TITLE = "GameOfLife";

    private static GameLoop gameLoop; 

    public static void main(final String args[]) {
        new Game();
    }

    Game() {
        setupGame();
        startGame();
    }

    private void setupGame(){
        gameLoop = new GameLoop();
        new GridRenderer(GRID_WIDTH, GRID_HEIGHT);
    }

    private void startGame(){
        gameLoop.start();
    }
}
