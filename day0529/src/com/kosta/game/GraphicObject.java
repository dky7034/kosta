package com.kosta.game;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GraphicObject {
    BufferedImage img = null;
    int x = 0;
    int y = 0;

    public GraphicObject(String name) {
        try {
            img = ImageIO.read(new File(name));
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
    public void update() {}
    public void draw(Graphics g) {
        g.drawImage(img, x, y, null);
    }
    public void keyPressed(KeyEvent e) {}

}
