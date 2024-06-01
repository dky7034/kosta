package com.kosta.exam11;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MyFrame extends JFrame {

    public MyFrame() {
        // 배치 관리자를 FlowLayout으로 설정
        setLayout(new FlowLayout());
        for (int i = 1; i <= 15; i++) {
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
