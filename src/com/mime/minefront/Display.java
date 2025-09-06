package com.mime.minefront;

import com.mime.minefront.graphics.*;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.io.Serial;

public class Display extends Canvas implements Runnable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Thread thread;
    private boolean running = false;
    private Render render;

    public Display() {
        render = new Render(WIDTH, HEIGHT);
    }

    private void start() {
        if (running) {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    private void stop() {
        if (!running) {
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    @Override
    public void run() {
        while (running) {
            tick();
            render();
        }
    }
    private void tick() {

    }
    private void render() {

    }

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;
    public static final String TITLE = "Mime Minefront";

    public static void main(String[] args) {
        Display game = new Display();
        JFrame frame = new JFrame();
        frame.add(game);
        frame.pack();
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle(TITLE);
    }
}
