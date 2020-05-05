package app;

import java.util.*;
import java.util.concurrent.*;

public class GameLoop {
    private static ScheduledExecutorService executor;
    private static final int FPS = 2;
    private static List<GameObject> gameObjects;
    private static Boolean running = false;

    GameLoop() {
        startGame();
    }

    public static void addListener(GameObject gameObject) {
        gameObjects.add(gameObject);
    }

    public static void removeListener(GameObject gameObject){
        gameObjects.remove(gameObject);
    }

    private void startGame() {
        if(running){
            return;
        }

        gameObjects = new ArrayList<GameObject>();

        executor = Executors.newScheduledThreadPool(1);

        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                updateGame();
            }
        }, 0, 1000 / FPS, TimeUnit.MILLISECONDS);
        running = true;
    }

    private void updateGame() {
        System.out.println("Updating game");
        for(GameObject gameObject : gameObjects){
            gameObject.update();
        }
        // the game code
    }

}