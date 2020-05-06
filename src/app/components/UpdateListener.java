package app.components;

import app.GameLoop;

public abstract class UpdateListener {

    UpdateListener(){
        GameLoop.addUpdateListener(this);
    }

    abstract public void update();
}