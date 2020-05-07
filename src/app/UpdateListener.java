package app;

public abstract class UpdateListener {

    protected UpdateListener(){
        Game.addUpdateListener(this);
    }

    abstract public void update();
}