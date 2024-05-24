package com.kosta.exam05;

import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class LinePanel extends Panel implements MouseListener {
    List<GraphicInfo> list;
    int x1,y1,x2,y2;

    public LinePanel() {
        list = new ArrayList<GraphicInfo>();
        addMouseListener(this);
    }


    @Override
    public void paint(Graphics g) {
        int x,y,width,height;
        for(GraphicInfo info:list) {
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

//			g.drawRect(x, y, width, height);
            g.drawOval(x, y, width, height);
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }


    @Override
    public void mousePressed(MouseEvent e) {

        x1 = e.getX();
        y1 = e.getY();

    }


    @Override
    public void mouseReleased(MouseEvent e) {
        x2 = e.getX();
        y2 = e.getY();
        list.add(new GraphicInfo(x1, y1, x2, y2));
        repaint();
    }


    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void setShapeType(String line) {

    }
}