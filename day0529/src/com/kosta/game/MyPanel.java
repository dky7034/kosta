package com.kosta.game;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyPanel extends JPanel implements KeyListener {
    Enemy enemy;
    Player player;
    Missile missile;
    public MyPanel() {
        super();
        this.addKeyListener(this);
        this.requestFocus();
        setFocusable(true);
        enemy = new Enemy("/game_img/enemy.jpeg");
        player = new Player("/game_img/player.jpeg");
        missile = new Missile("/game_img/missile.jpeg");
    }
    class MyThread extends Thread {
        public void run() {
            while (true) {
                enemy.update();
                player.update();
            }
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
