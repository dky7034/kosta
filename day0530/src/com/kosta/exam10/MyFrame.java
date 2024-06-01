package com.kosta.exam10;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    JButton button01;
    JButton button02;

    public MyFrame() {
        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 배치 관리자를 FlowLayout으로 설정
        setLayout(new FlowLayout());
        button01 = new JButton("남자");
        button02 = new JButton("여자");

        add(button01);
        add(button02);
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}
