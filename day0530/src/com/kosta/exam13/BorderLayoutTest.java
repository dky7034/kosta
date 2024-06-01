package com.kosta.exam13;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutTest extends JFrame {
    public BorderLayoutTest() {
        setLayout(new BorderLayout());
        add(new JButton("위"), BorderLayout.NORTH);
        add(new JButton("아래"), BorderLayout.SOUTH);
        add(new JButton("왼쪽"), BorderLayout.WEST);
        add(new JButton("오른쪽"), BorderLayout.EAST);
        add(new JButton("가운데"), BorderLayout.CENTER);
        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new BorderLayoutTest();
    }
}
