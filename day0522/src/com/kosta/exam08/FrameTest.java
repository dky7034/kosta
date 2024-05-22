package com.kosta.exam08;

import java.awt.*;

public class FrameTest {
    public static void main(String[] args) {
        Frame frame = new Frame("우리반 반장은 변시우!");
        System.out.println("창을 만들었어요!");
        frame.setBackground(Color.pink);
        frame.setSize(700,  700);
        frame.setVisible(true);

    }
}
