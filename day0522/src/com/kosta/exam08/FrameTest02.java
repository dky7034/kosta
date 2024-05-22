package com.kosta.exam08;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class MyFrane extends Frame implements MouseListener {

    public MyFrane(String title) {
        super(title);
        setSize(700, 500);
        setVisible(true);
        setBackground(Color.pink);
        // 마우스 일처리 담당자를 등록합니다.
        addMouseListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("마우스 클릭");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("마우스 누름");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("마우스 뗴어짐");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("마우스 들어옴");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("마우스 나감");
    }
}

public class FrameTest02 {
    public static void main(String[] args) {
//        MyFrane myFrane = new MyFrane("제목");
        new MyFrane("hello JAVA");
    }
}
