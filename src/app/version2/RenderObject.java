package app.version2;

import java.awt.Graphics;

public abstract class RenderObject {
    
    RenderObject(){
        Game.addRenderListener(this);
    }

    abstract public void render(Graphics g);
}