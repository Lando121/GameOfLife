package app.game_logic.game_objects;

import app.game_logic.GameLoop;

public abstract class GameObject {
    protected GameObject(){
        GameLoop.addListener(this);
    }

    public abstract void update();

    public abstract void lateUpdate();
}