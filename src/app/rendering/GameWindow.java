// package app.rendering;

// import java.awt.Canvas;
// import java.awt.Color;
// import java.awt.Dimension;
// import java.awt.Graphics;
// import java.awt.image.BufferStrategy;
// import javax.swing.JFrame;

// import app.game_logic.GameLoop;

// public class GameWindow extends Canvas {

//     private static final long serialVersionUID = 1L;
//     public static final int WIDTH = 1000;
//     public static final int HEIGHT = 1000;
//     private static final String TITLE = "GameOfLife";

//     private JFrame frame;
//     private GridRenderer gridRenderer;

//     private boolean running = false;

//     public GameWindow() {
//         setWindowSize();
//         initFrame();
//         gridRenderer = new GridRenderer();
//         //start();
//     }

//     private void setWindowSize() {
//         Dimension size = new Dimension(WIDTH, HEIGHT);
//         setPreferredSize(size);
//         setMaximumSize(size);
//         setMinimumSize(size);
//     }

//     private void initFrame() {
//         frame = new JFrame(TITLE);
//         frame.add(this);
//         frame.pack();
//         frame.setResizable(false);
//         frame.setLocationRelativeTo(null);
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setVisible(true);
//     }

//     public void stop() {
//         if (!running) {
//             return;
//         }
//         running = false;
//         frame.dispose();
//     }

//     public void render() {
//         System.out.println("rendering app");
//         BufferStrategy bufferStrategy = getBufferStrategy();
//         if (bufferStrategy == null) {
//             createBufferStrategy(2);
//             return;
//         }

//         Graphics g = bufferStrategy.getDrawGraphics();
//         g.setColor(Color.WHITE);
//         g.fillRect(0, 0, getWidth(), getHeight());
//         gridRenderer.render(g);

//         g.dispose();
//         bufferStrategy.show();
//     }
// }