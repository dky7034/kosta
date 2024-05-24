package com.kosta.exam01;

import java.awt.*;

// MyFrame 클래스는 Frame을 상속받아 GUI 윈도우를 생성합니다.
public class MyFrame extends Frame {

    // MyFrame의 구성 요소로 LinePanel을 선언합니다.
    LinePanel lp;

    // MyFrame의 생성자
    public MyFrame() {

        // LinePanel 구성 요소를 초기화합니다.
        lp = new LinePanel();

        // LinePanel을 프레임에 추가합니다.
        add(lp);

        // 프레임의 크기를 설정합니다.
        setSize(400, 300);

        // 프레임을 화면에 표시합니다.
        setVisible(true);
    }
}
