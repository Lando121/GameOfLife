package app;

import java.awt.Graphics;

public abstract class RenderListener {
    
    protected RenderListener(){
        Game.addRenderListener(this);
    }

    abstract public void render(Graphics g);
}