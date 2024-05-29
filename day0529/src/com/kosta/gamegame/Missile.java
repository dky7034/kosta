package com.kosta.gamegame;

import java.awt.event.KeyEvent;

// GraphicObject를 상속받아 "미사일" 클래스를 만듭니다.
public class Missile extends GraphicObject {

    // 미사일이 발사되었는지 판별하기 위한 변수를 선언합니다.
    boolean launched = false;

    // 미사일 생성 시에 미사일로 표현할 이미지 파일명을 전달받아
    public Missile(String name) {
        // 부모 생성자인 GraphicObject 생성자에게 전달합니다.
        super(name);
        // 맨 처음 미사일의 위치를 화면에서 벗어난 구석탱이(!)에 놓습니다.
        x = -200;
    }

    @Override
    public void update() {
        // 미사일이 발사되었으면 y의 위치를 1씩 감소시켜서 위로 이동하도록 합니다.
        if (launched) {
            y-=1;
        }
        // y의 위치가 화면에서 벗어나면(-100보다 작아지면)
        // launched에 false를 저장하여 미사일을 움직이지 않도록 합니다.
        if (y < -100) {
            launched = false;
        }
    }

    // 키를 누르면 눌러진 키 이벤트 정보와
    // 플레이어의 위치 x, y를 가지고 이 메서드를 호출합니다.
    public void keyPressed(KeyEvent event, int x, int y) {
        // 만약 스페이스 키가 눌러지면
        if (event.getKeyCode() == KeyEvent.VK_SPACE) {

            // 미사일을 발사하기 위하여 launched에 true를 저장합니다.
            launched = true;

            // 미사일을 플레이어의 위치에서부터 발사하기 위하여
            // 미사일의 x, y를 매개변수로 전달받은 플레이어의 위치 x, y로 설정합니다.
            this.x = x;
            this.y = y;
        }
    }
}
