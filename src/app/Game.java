
package app;

import java.util.ArrayList;

import app.components.GridComponent;
import app.rendering.Renderer;
import java.beans.EventHandler;

public class Game {
    private static final int GRID_WIDTH = 100;
    private static final int GRID_HEIGHT = 100; 
    public static final int WINDOW_WIDTH = 1000;
    public static final int WINDOW_HEIGHT = 1000;

    private GameLoop gameLoop; 
    private Renderer renderer;

    private static ArrayList<UpdateListener> updateListeners = new ArrayList<>();
    private static ArrayList<RenderListener> renderListeners = new ArrayList<>();

    public static void main(final String args[]) {
        new Game();
    }

    Game() {
        setupGame();
        startGame();       
    }

    private void setupGame(){
        gameLoop = new GameLoop(this);
        renderer = new Renderer();
        new GridComponent(GRID_WIDTH, GRID_HEIGHT);
    }

    public void startGame(){
        gameLoop.start();
    }

    public void stopGame(){
        gameLoop.stop();
    }

    public void updateGame(){
        for (UpdateListener updateListener : updateListeners) {
            if (updateListener != null) {
                updateListener.update();
            }
        }
    }

    public void renderGame(){
        renderer.render(renderListeners);
    }

    public static void addRenderListener(RenderListener renderListener) {
        renderListeners.add(renderListener);
    }

    public static void removeRenderListener(RenderListener renderListener) {
        renderListeners.remove(renderListener);
    }

    public static void addUpdateListener(UpdateListener updateListener) {
        updateListeners.add(updateListener);
    }

    public static void removeUpdateListener(UpdateListener updateListener) {
        updateListeners.remove(updateListener);
    }
}
