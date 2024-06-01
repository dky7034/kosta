package com.kosta.exam09;

import javax.swing.*;

public class MyFrame extends JFrame {
    JButton button01;
    JButton button02;

    public MyFrame() {
        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button01 = new JButton("남자");
        button02 = new JButton("여자");

        add(button01);
        add(button02);
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}
