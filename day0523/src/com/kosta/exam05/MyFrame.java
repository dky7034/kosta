package com.kosta.exam05;

import java.awt.Frame;

// GUI 프로그래밍을 위하여
// 자바가 제공하는 Frame을 상속받은 MyFrame 클래스를 만들었습니다.
public class MyFrame extends Frame {

    // MyFrame의 구성요소(부속품, 멤버변수)로 LinePanel을 선언합니다.
    LinePanel lp;

    // Constructor
    public MyFrame() {
        // 생성자에서 부속품이 LinePanel을 생성합니다.
        lp = new LinePanel();
        // 생성된 LinePanel을 프레임에 저장합니다.
        // 저장하지 않으면 패널이 보이지 않습니다.
        add(lp);
        // 프레임의 크기를 설정합니다.
        setSize(400, 300);
        // 프레임을 화면에 보여줄 것을 설정합니다.
        setVisible(true);
    }

}
