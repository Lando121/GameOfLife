package app;

public abstract class UpdateListener {

    protected UpdateListener(){
        GameLoop.addUpdateListener(this);
    }

    abstract public void update();
}