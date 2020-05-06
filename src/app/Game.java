
package app;

import java.util.ArrayList;
import java.util.List;
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
    private boolean isRunning = true;

    public static void main(String args[]) {
        new Game();
    }

    public static void addUpdateListener(GameObject gameObject){
        gameObjects.add(gameObject);
    }

    public static void removeRenderListener(GameObject gameObject){
        gameObjects.remove(gameObject);
    }

    public static void addRenderListener(RenderObject renderObject){
        renderObjects.add(renderObject);
    }

    public static void removeRenderListener(RenderObject renderObject){
        renderObjects.remove(renderObject);
    }

    Game() {
        Window window = new Window(WIDTH, HEIGHT, TITLE, this);
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
        for (GameObject gameObject : gameObjects) {
            gameObject.update();
        }
    }

    private void render() {
        BufferStrategy bufferstrategy = getBufferStrategy();

        if (bufferstrategy == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics g = bufferstrategy.getDrawGraphics();

        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());

        for (RenderObject renderObject : renderObjects) {
            renderObject.render(g);
        }

        g.dispose();
        bufferstrategy.show();
    }
}
