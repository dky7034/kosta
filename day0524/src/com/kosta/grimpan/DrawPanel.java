package com.kosta.grimpan;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class DrawPanel extends Panel implements MouseListener {
    List<GraphicInfo> list;
    int x1, y1, x2, y2; // 도형의 시작(x)좌표와 끝(y)좌표를 저장
    int drawType; // 0: 선, 1: 사각형, 2: 원
    int drawColor; // 0: 빨강, 1: 파랑, 2: 초록

    public DrawPanel() {
        list = new ArrayList<GraphicInfo>();
        addMouseListener(this);
    }

    @Override
    public void paint(Graphics g) {
        int x, y, width, height;
        for(GraphicInfo info : list) {
            x = info.getX1();
            y = info.getY1();

            width = info.getX2() - info.getX1();
            height = info.getY2() - info.getY1();

            if(info.getX2() < info.getX1()) {
                x = info.getX2();
                width = info.getX1() - info.getX2();
            }

            if(info.getY2() < info.getY1()) {
                y = info.getY2();
                height = info.getY1() - info.getY2();
            }

            // 색상(빨강, 파랑, 초록)
            switch (info.getDrawColor()) {
                case 0:
                    g.setColor(Color.RED);
                    break;
                case 1:
                    g.setColor(Color.BLUE);
                    break;
                case 2:
                    g.setColor(Color.GREEN);
                    break;
            }
            // 모양(선, 사각형, 원)
            switch(info.getDrawType()) {
                case 0:
                    g.drawLine(info.getX1(), info.getY1(), info.getX2(), info.getY2());
                    break;
                case 1:
                    g.drawRect(info.getX1(), info.getY1(), width, height);
                    break;
                case 2:
                    g.drawOval(info.getX1(), info.getY1(), width, height);
                    break;
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        x1 = e.getX();
        y1 = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();
        list.add(new GraphicInfo(x1, y1, x2, y2, drawType, drawColor));
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

}