package app.version2;

import java.awt.Graphics;

public class TestRenderObject extends RenderObject {

    @Override
    public void render(Graphics g) {
        System.out.println("rendering object");
    }
    
}