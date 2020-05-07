package app.rendering;

import javax.swing.JFrame;
import java.awt.Dimension;

public class Window {
    private static final String WINDOW_TITLE = "Game Of Life";

    public Window (int width, int height, Renderer game) {
        game.setPreferredSize(new Dimension (width, height));
        game.setMaximumSize(new Dimension (width, height));
        game.setMinimumSize(new Dimension (width, height));

        JFrame frame = new JFrame (WINDOW_TITLE);
        frame.add (game);
        frame.pack ();
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setResizable (false);
        frame.setLocationRelativeTo (null);
        frame.setVisible (true);
    }
}