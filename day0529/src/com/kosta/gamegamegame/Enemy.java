package com.kosta.gamegamegame;

// GraphicObject를 상속받아 "적" 클래스를 만듭니다.
public class Enemy extends GraphicObject {
    // 적은 가로 방향으로 왔다 갔다 하도록 합니다.
    int dx = -15;

    // 적 생성 시에 적으로 표현할 이미지 파일명을 전달받아
    public Enemy(String name) {
        // 부모 생성자인 GraphicObject 생성자에게 전달합니다.
        super(name);
        // 맨 처음 적의 위치를 700, 0으로 설정합니다.
        x = 700;
        y = 0;
    }

    // 적의 위치를 갱신하기 위하여 update를 오버라이딩합니다.
    @Override
    public void update() {
        // x 위치가 왼쪽 끝에 도달하면
        // 다시 오른쪽으로 이동시키기 위하여 dx를 양수 15로 설정합니다.
        if (x < 0) dx = +15;
        // x 위치가 오른쪽 끝에 도달하면
        // 다시 왼쪽으로 이동시키기 위하여 dx를 음수 15로 설정합니다.
        if (x > 700) dx = -15;
        // x 위치를 dx만큼 갱신합니다.
        x += dx;
    }
}
