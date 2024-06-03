package com.kosta.exam03;

import javax.swing.*;
import java.awt.*;

public class ImageButton extends JFrame {
    ImageIcon icon;
    ImageIcon icon2;
    ImageIcon icon3;
    JButton btn;

    public ImageButton() {
        icon = new ImageIcon("/Users/donggyun/intellij-workspace/kosta/day0603/apple.gif");
        icon2 = new ImageIcon("/Users/donggyun/intellij-workspace/kosta/day0603/banana.gif");
        icon3 = new ImageIcon("/Users/donggyun/intellij-workspace/kosta/day0603/grape.gif");

        btn = new JButton(icon);
        btn.setRolloverIcon(icon2);
        btn.setPressedIcon(icon3);

        setLayout(new FlowLayout());
        add(btn);

        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ImageButton();
    }
}
