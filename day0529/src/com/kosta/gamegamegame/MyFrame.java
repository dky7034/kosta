package com.kosta.gamegamegame;

import javax.swing.JFrame;
import java.awt.*;

public class MyFrame extends JFrame {
    MyPanel panel;
    public MyFrame() {
        panel = new MyPanel();
        panel.setBackground(Color.white);
        add(panel);
        setSize(800, 600);
        setVisible(true);
    }
}
