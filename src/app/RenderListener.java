package app;

import java.awt.Graphics;

public abstract class RenderListener {
    
    protected RenderListener(){
        GameLoop.addRenderListener(this);
    }

    abstract public void render(Graphics g);
}