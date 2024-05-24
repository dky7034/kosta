package com.kosta.grimpan;

public class GrimpanTest {
    public static void main(String[] args) {
        // 이 속성을 설정하여 메뉴바를 상단 시스템 메뉴바가 아닌 프레임에 표시되도록 합니다.
        System.setProperty("apple.laf.useScreenMenuBar", "false");
        new MyFrame();
    }
}
