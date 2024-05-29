package com.kosta.gamegame;

import java.awt.event.KeyEvent;

// GrphicObject를 상속받아 "플레이어" 클래스를 만듭니다.
public class Player extends GraphicObject {

    // 플레이어 생성 시에 플레이어로 표현할 이미지 파일명을 전달받아
    public Player(String name) {
        // 부모 생성자인 GraphicObject 생성자에게 전달합니다.
        super(name);
        // 맨 처음 플레이어의 위치를 350, 250으로 설정합니다.
        x = 350;
        y = 0;
    }

    // KeyPressed 메서드를 오버라이딩 합니다.
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {x -= 10;}
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {x += 10;}
        if (e.getKeyCode() == KeyEvent.VK_UP) {y -= 10;}
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {y += 10;}
    }
}
