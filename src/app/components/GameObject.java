package app.components;

import app.Game;

public abstract class GameObject {

    GameObject(){
        Game.addUpdateListener(this);
    }

    abstract public void update();
}