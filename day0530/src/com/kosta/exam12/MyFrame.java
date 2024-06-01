package com.kosta.exam12;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    public MyFrame() {
        // 배치 관리자를 FlowLayout으로 설정
        // 배치 관리자를 GridLayout으로 설정
//        setLayout(new GridLayout(3, 5));
        setLayout(new GridLayout(5, 3));
        for (int i = 1; i <= 11; i++) {
            // 버튼 객체를 생성
            JButton button = new JButton(String.valueOf(i));
            this.add(button);
        }
        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}
