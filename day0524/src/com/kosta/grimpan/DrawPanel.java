package com.kosta.grimpan;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

/*
// *** DrawPanel 클래스의 계층 구조 ***
java.lang.Object
   └── java.awt.Component
         └── java.awt.Container
               └── java.awt.Panel
                     └── com.kosta.grimpan.DrawPanel
==> DrawPanel 클래스는 Panel 클래스를 확장했기 때문에, Component 클래스에서 정의된 paint(Graphics g)메서드를 오버라이드 할 수 있음!
*/

// Controller 역할 수행
public class DrawPanel extends Panel implements MouseListener {
    // GraphicInfo 제네릭 타입의 list 선언.
    List<GraphicInfo> list;
    // 도형의 시작 좌표와 끝 좌표를 저장하는 변수들 선언.
    int x1, y1, x2, y2; // 도형의 시작(x)좌표와 끝(y)좌표를 저장
    // 그릴 도형의 모향을 정하는 변수 선언.
    int drawType; // 0: 선, 1: 사각형, 2: 원
    // 그릴 도형의 색상을 정하는 변수 선언.
    int drawColor; // 0: 빨강, 1: 파랑, 2: 초록

    // 생성자
    // DraPanel 객체를 호출 및 생성하게 되면
    // GraphicInfo 제네릭 타입의 ArrayList가 생성됩니다.
    // 이 리스트는 그려진 도형의 정보를 저장하는 데 사용됩니다.
    // 또, 마우스 이벤트를 처리하기 위해 현재 객체에
    // MouseListener를 추가합니다.
    public DrawPanel() {
        list = new ArrayList<GraphicInfo>();
        addMouseListener(this);
    }

    // 메서드 오버라이딩
    // Component 클래스에서 정의된 paint(Graphics g) 메서드 오버라이딩 (DrawPanl 클래스가 Panel 클래스를 확장했기 때문에 가능함)
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