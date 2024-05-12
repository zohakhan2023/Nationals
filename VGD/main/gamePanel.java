package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Graphics;
import javax.swing.JPanel;

import Entity.player;

import java.awt.event.KeyListener;

public class gamePanel extends JPanel implements Runnable {
    final int originalTileSize = 32; // pixels: 16x16 for everything
    final int scale = 2;// scale to look 48*48
    public final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 18;
    final int maxScreenRow = 24;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;
    int FPS = 60;
    KeyHandler kH = new KeyHandler();
    Thread gT;
    player p = new player(this, kH);

    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 5;

    public gamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.LIGHT_GRAY);
        this.setDoubleBuffered(true);
        this.addKeyListener(kH);
        this.setFocusable(true);

    }

    public void gameLoop() {
    }

    public void startGameThread() {
        gT = new Thread(this);
        gT.start();
    }

    public void run() {
        double drawInterval = 100000000000.0 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        while (gT != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    public void update() {
        this.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        player.Draw(g2D);
        g2D.dispose();
    }
}
