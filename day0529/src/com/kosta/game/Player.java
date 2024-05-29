package com.kosta.game;

import java.awt.event.KeyEvent;

public class Player extends GraphicObject {
    public Player(String name) {
        super(name);
        x = 150;
        y = 350;
    }
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {x -= 10;}
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {x += 10;}
        if (e.getKeyCode() == KeyEvent.VK_UP) {y -= 10;}
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {y += 10;}
    }
}
