package app.version2;

public abstract class GameObject {

    GameObject(){
        Game.addUpdateListener(this);
    }

    abstract public void update();
    abstract public void lateUpdate();
}