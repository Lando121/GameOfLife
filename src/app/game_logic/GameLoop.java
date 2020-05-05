// package app.game_logic;

// import java.util.*;

// import app.game_logic.game_objects.GameObject;

// public class GameLoop extends TimerTask{

//     private static List<GameObject> gameObjects;

//     public GameLoop() {
//         gameObjects = new ArrayList<GameObject>();
//     }

//     public static void addListener(GameObject gameObject) {
//         gameObjects.add(gameObject);
//     }

//     public static void removeListener(GameObject gameObject){
//         gameObjects.remove(gameObject);
//     }

//     // public void updateGame() {
//     //     System.out.println("game update");
//     //     for(GameObject gameObject : gameObjects){
//     //         gameObject.update();
//     //     }
//     // }

//     // public void lateUpdate() {
//     //     for(GameObject gameObject : gameObjects){
//     //         gameObject.lateUpdate();
//     //     }
//     // }

//     @Override
//     public void run() {
//         for(GameObject gameObject : gameObjects){
//             gameObject.update();
//         }
//         for(GameObject gameObject : gameObjects){
//             gameObject.lateUpdate();
//         }
//     }

// }