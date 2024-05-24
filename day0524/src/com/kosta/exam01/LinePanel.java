package com.kosta.exam01;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Panel은 복잡한 화면 구성을 위한 서브 컨테이너 역할을 하거나
// 그래픽을 표현하기 위한 화면 구성 요소입니다.
// LinePanel 클래스는 그래픽을 표현하기 위해 Panel 클래스를 상속받고
// 마우스 움직임에 대한 이벤트 처리를 위해 MouseListener 인터페이스를 구현합니다.
public class LinePanel extends Panel implements MouseListener {

    // 선을 그리면 이전에 그려진 선은 사라집니다.
    // 그려진 모든 선을 저장하기 위해 리스트에 담아두고,
    // paint 메소드에서 리스트에 담긴 요소를 모두 다시 그려줘야 합니다.
    List<GraphicInfo> list; // 화면에 그려진 모든 그래픽(선)을 담기 위한 리스트
    int x1, y1, x2, y2; // 현재 그래픽(선)의 시작점과 끝점을 저장하기 위한 변수

    // LinePanel 생성자
    public LinePanel() {
//        list = new ArrayList<GraphicInfo>(); // 리스트를 생성
        list = new LinkedList<>(); // 리스트를 생성
        addMouseListener(this); // 현재 패널(LinePanel)에 마우스 이벤트 리스너를 등록
    }

    // GUI 프로그래밍에서 화면을 다시 그려야 할 필요가 있으면
    // paint 메소드가 자동으로 동작합니다.
    // 처음 LinePanel을 생성하여 프레임에 담거나, 프레임의 크기를 조절할 때 등
    // 다시 그려줘야 할 필요가 있을 때 자동으로 동작합니다.
    // repaint 메소드를 호출하여 paint 메소드를 요청할 수도 있습니다.
    @Override
    public void paint(Graphics g) {
        // 리스트에 담긴 모든 그래픽(선)을 그립니다.
        for (GraphicInfo info : list) {
            g.drawLine(info.getX1(), info.getY1(), info.getX2(), info.getY2());
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // 구현 필요 없음
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // 마우스가 눌러졌을 때 동작하는 메소드
        // 마우스가 눌러진 위치 정보를 x1, y1에 저장
        x1 = e.getX();
        y1 = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // 마우스를 떼었을 때 동작하는 메소드
        // 마우스가 떼어진 위치 정보를 x2, y2에 저장
        x2 = e.getX();
        y2 = e.getY();

        // 현재 그려진 그래픽(선)의 정보를 리스트에 추가
        list.add(new GraphicInfo(x1, y1, x2, y2));

        // 리스트에 담긴 그래픽 정보를 다시 그리도록 요청
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // 구현 필요 없음
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // 구현 필요 없음
    }
}
