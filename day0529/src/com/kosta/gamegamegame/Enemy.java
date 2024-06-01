package com.kosta.gamegamegame;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

// GraphicObject를 상속받아 "적" 클래스를 만듭니다.
public class Enemy extends GraphicObject {
    private boolean isHit = false;
    private Image hitImage;

    // 적은 가로 방향으로 왔다 갔다 하도록 합니다.
    int dx = -15;

    // 적 생성 시에 적으로 표현할 이미지 파일명을 전달받아
    public Enemy(String name) {
        // 부모 생성자인 GraphicObject 생성자에게 전달합니다.
        super(name);
        // 맨 처음 적의 위치를 700, 0으로 설정합니다.
        x = 300;
        y = 0;
        // 맞았을 때의 이미지를 설정합니다.
        try {
            hitImage = ImageIO.read(new File("/Users/donggyun/intellij-workspace/kosta/day0529/src/com/kosta/enemy01_die.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 적의 위치를 갱신하기 위하여 update를 오버라이딩합니다.
    @Override
    public void update() {
        // 적이 맞았으면 움직임을 멈춤
        if (isHit) {return;}
        // x 위치가 왼쪽 끝에 도달하면
        // 다시 오른쪽으로 이동시키기 위하여 dx를 양수 15로 설정합니다.
        if (x < 0) dx = +15;
        // x 위치가 오른쪽 끝에 도달하면
        // 다시 왼쪽으로 이동시키기 위하여 dx를 음수 15로 설정합니다.
        if (x > 700) dx = -15;
        // x 위치를 dx만큼 갱신합니다.
        x += dx;
    }

    // 적이 미사일에 맞았는지 여부를 판별하는 메서드
    // 미사일 객체를 매개변수로 전달받아
    // 미사일 객체와 적의 좌표를 비교하여 적이 맞았는지를 판별합니다.
    // 미사일 객체의 x값이
    public boolean isHit(Missile missile) {
        if ((missile.x >= x) && (missile.x <= x + 40)
                && (missile.y >= y) && (missile.y <= y + 40)) {
            isHit = true;
            return true;
        }
        return false;
    }

    public boolean isHit() {
        return isHit;
    }

    public void draw(Graphics g) {
        if (isHit) {
            g.drawImage(hitImage, x, y, null);
        } else {
            g.drawImage(img, x, y, null);
        }
    }

}
