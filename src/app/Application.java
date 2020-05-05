
package app;

import app.game_logic.GameLoop;
import app.rendering.GameWindow;

public class Application {
    public static void main(String args[]) {
        new GameLoop();
        new GameWindow();
    }
}
