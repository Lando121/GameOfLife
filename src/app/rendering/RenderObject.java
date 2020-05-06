package app.rendering;

import java.awt.Graphics;

import app.Game;

public abstract class RenderObject {
    
    RenderObject(){
        Game.addRenderListener(this);
    }

    abstract public void render(Graphics g);
}