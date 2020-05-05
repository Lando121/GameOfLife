package app;

public abstract class GameObject {
    GameObject(){
        GameLoop.addListener(this);
    }

    abstract void update();
}