package app.game_logic;

import java.util.*;
import java.util.concurrent.*;

import app.game_logic.game_objects.GameObject;

public class GameLoop {
    private static ScheduledExecutorService executor;
    private static final int UpdatesPerSecond = 2;
    private static List<GameObject> gameObjects;
    private static Boolean running = false;

    public GameLoop() {
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
                lateUpdate();
            }
        }, 0, 1000 / UpdatesPerSecond, TimeUnit.MILLISECONDS);
        running = true;
    }

    private void updateGame() {
        for(GameObject gameObject : gameObjects){
            gameObject.update();
        }
    }

    private void lateUpdate() {
        for(GameObject gameObject : gameObjects){
            gameObject.lateUpdate();
        }
    }

}