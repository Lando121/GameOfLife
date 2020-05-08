package app;

import javax.swing.JFrame;
import java.awt.Dimension;

public class Window {
    private static final String WINDOW_TITLE = "Game Of Life";

    public Window(int width, int height, Renderer renderer) {
        renderer.setPreferredSize(new Dimension(width, height));
        renderer.setMaximumSize(new Dimension(width, height));
        renderer.setMinimumSize(new Dimension(width, height));

        JFrame frame = new JFrame(WINDOW_TITLE);
        frame.add(renderer);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}