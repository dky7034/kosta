package com.kosta.gamegamegame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

// GraphicObject를 상속받아 "적" 클래스를 만듭니다.
public class Enemy extends GraphicObject {
    private boolean isHit = false;
    private Image hitImage;

    // x축 이동 거리를 위한 변수
    int dx;
    // y축 이동 거리를 위한 변수
    int dy;

    // 적 생성 시에 적으로 표현할 이미지 파일명을 전달받아
    public Enemy(String name) {
        // 부모 생성자인 GraphicObject 생성자에게 전달합니다.
        super(name);

        // 난수 발생을 위한 Random 객체를 생성
        Random r = new Random();

        // 맨 처음 적의 x위치를 0~799 사이의 난수로 설정합니다.
        x = r.nextInt(600);

        // 맨 처음 적의 y위치를 0~599 사이의 난수로 설정합니다.
        y = r.nextInt(400);

        // 적의 x축 이동거리를 -19 ~ 19사이의 난수로 설정합니다.
        dx = r.nextInt(40) - 19;

        // 적의 y축 이동거리를 -9 ~ 9사이의 난수로 설정합니다.
        dy = r.nextInt(20) - 9;

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
        if (isHit) {
            return;
        }

        // 적의 x위치를 x축 이동 거리만큼 이동합니다.
        x += dx;
        // 적의 y위치를 y축 이동 거리만큼 이동합니다.
        y += dy;

        // 적의 x위치가 왼쪽 끝이나 오른쪽 끝에 도달하면 이동방향을 반대로 합니다.
        if (x < 0 || x > 750) {
            dx = -dx;
        }
        // 적의 y위치가 위쪽 끝이나 아래쪽 끝에 도달하면 이동방향을 반대로 합니다.
        if (y < 0 || y > 550) {
            dy = -dy;
        }
    }

    // 적이 미사일에 맞았는지 여부를 판별하는 메서드
    public boolean isHit(Missile missile) {
        if ((missile.x >= x) && (missile.x <= x + 40)
                && (missile.y >= y) && (missile.y <= y + 40)) {
            isHit = true;
            return true;
        }
        return false;
    }

    public void draw(Graphics g) {
        if (isHit) {
            g.drawImage(hitImage, x, y, null);
        } else {
            g.drawImage(img, x, y, null);
        }
    }
}
