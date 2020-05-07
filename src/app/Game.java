
package app;

import app.components.GridComponent;

public class Game {
    private static final int GRID_WIDTH = 100;
    private static final int GRID_HEIGHT = 100; 
    public static final int WINDOW_WIDTH = 1000;
    public static final int WINDOW_HEIGHT = 1000;

    private GameLoop gameLoop; 

    public static void main(final String args[]) {
        new Game();
    }

    Game() {
        setupGame();
        startGame();
    }

    private void setupGame(){
        gameLoop = new GameLoop();
        new GridComponent(GRID_WIDTH, GRID_HEIGHT);
    }

    private void startGame(){
        gameLoop.start();
    }
}
