package app.rendering;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;

public class GameWindow extends Canvas {
    private ScheduledExecutorService executor;

    private static final long serialVersionUID = 1L;
    public static final int WIDTH = 1000;
    public static final int HEIGHT = 1000;
    private static final String TITLE = "GameOfLife";
    private static final int FPS = 30;

    private JFrame frame;
    private GridRenderer gridRenderer;

    private boolean running = false;

    public GameWindow() {
        setWindowSize();
        initFrame();
        start();
    }

    private void setWindowSize() {
        Dimension size = new Dimension(WIDTH, HEIGHT);
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);
    }

    private void initFrame() {
        frame = new JFrame(TITLE);
        frame.add(this);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void start() {
        if(running){
            return;
        }
        gridRenderer = new GridRenderer();
        executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                render();
            }
        }, 0, 1000 / FPS, TimeUnit.MILLISECONDS);
    }

    public void stop() {
        if (!running) {
            return;
        }
        running = false;
        frame.dispose();
    }

    public void render() {
        BufferStrategy bufferStrategy = getBufferStrategy();
        if (bufferStrategy == null) {
            createBufferStrategy(2);
            return;
        }

        Graphics g = bufferStrategy.getDrawGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        gridRenderer.render(g);

        g.dispose();
        bufferStrategy.show();
    }
}