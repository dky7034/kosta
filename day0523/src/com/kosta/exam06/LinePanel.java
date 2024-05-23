package com.kosta.exam06;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LinePanel extends Panel implements MouseListener {

    int x1, y1, x2, y2;

    public LinePanel() {
        System.out.println("생성자 동작함!");
        addMouseListener(this);
    }

    @Override
    public void paint(Graphics g) {
        System.out.println("paint 동작함");
        g.drawLine(x1, y1, x2, y2);

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("마우스 눌러짐(pressed)");
        x1 = e.getX();
        y1 = e.getY();

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("마우스 떼어짐(released)");
        x2 = e.getX();
        y2 = e.getY();
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

//    @Override
//    public void paintComponents(Graphics g) {
//        System.out.println("paintComponents 동작함");
//        g.drawLine(300, 300, 400, 400);
//    }

}
