package app.rendering;

import java.awt.Graphics;

import app.GameLoop;

public abstract class RenderListener {
    
    RenderListener(){
        GameLoop.addRenderListener(this);
    }

    abstract public void render(Graphics g);
}