package com.kosta.exam05;

import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

// Panel 클래스는 복잡한 화면 구성을 위한 서브컨테이너 역할이나
// 그래픽을 표현하기 위해 사용됩니다.
// LinePanel 클래스는 Panel을 상속받아 그래픽을 표시하고,
// MouseListener를 구현하여 마우스 이벤트를 처리합니다.
public class LinePanel extends Panel implements MouseListener {

    // 그린 선들이 화면에서 사라지지 않게 하기 위해
    // 각 선을 리스트에 저장하고, paint 메서드에서 리스트에 있는 모든 선을 다시 그립니다.

    // 화면에 그려진 모든 선의 정보를 담기 위한 리스트를 선언합니다.
    ArrayList<GraphicInfo> list;

    // 현재 그리는 선의 시작점 (x1, y1)과 끝점 (x2, y2)를 저장할 멤버 변수를 선언합니다.
    int x1, y1, x2, y2;

    public LinePanel() { // LinePanel 생성자, 객체가 생성될 때 자동으로 호출됩니다.
        // 리스트를 초기화합니다.
        list = new ArrayList<GraphicInfo>();
        // 현재 LinePanel에 마우스 이벤트 처리자를 등록합니다.
        addMouseListener(this);
    }

    // paint 메서드는 화면을 다시 그려야 할 때 자동으로 호출됩니다.
    // LinePanel이 처음 생성되어 프레임에 추가되거나, 패널의 크기가 변경될 때도 호출됩니다.
    // 수동으로 다시 그리기 요청을 하려면 repaint()를 호출해야 합니다.
    @Override
    public void paint(Graphics g) {
        System.out.println("paint 메서드 호출됨");
        // 리스트에 저장된 모든 선을 그립니다.
        for (GraphicInfo info : list) {
            g.drawLine(info.getX1(), info.getY1(), info.getX2(), info.getY2());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // 마우스 버튼이 눌렸을 때 호출됩니다.
        // 마우스가 눌린 위치를 선의 시작점으로 저장합니다.
        System.out.println("마우스 눌림");
        x1 = e.getX();
        y1 = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // 마우스 버튼이 떼어졌을 때 호출됩니다.
        // 마우스가 떼어진 위치를 선의 끝점으로 저장합니다.
        System.out.println("마우스 떼어짐");
        x2 = e.getX();
        y2 = e.getY();

        // 시작점과 끝점으로 구성된 GraphicInfo 객체를 생성하여 리스트에 추가합니다.
        list.add(new GraphicInfo(x1, y1, x2, y2));
        // 패널을 다시 그리도록 요청합니다.
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    // paintComponents 메서드는 컴포넌트를 그리는 대체 메서드로, 이 예제에서는 사용되지 않았습니다.
//    @Override
//    public void paintComponents(Graphics g) {
//        System.out.println("paintComponents 메서드 호출됨");
//        g.drawLine(300, 300, 400, 400);
//    }

}
