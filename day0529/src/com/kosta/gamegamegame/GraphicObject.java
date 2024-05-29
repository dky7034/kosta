package com.kosta.gamegamegame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// 미래에 만들어질 적, 미사일, 플레이어의 공통된 특성을 뽑아서
// 부모 클래스를 생성합니다.
public class GraphicObject {

    // 적, 미사일, 플레이어를 나타낼 이미지를 담을 변수
    BufferedImage img = null;

    // 이미지를 출력할 좌표
    int x = 0, y = 0;

    // 생성자
    // 생성 시에 이미지 파일명을 매개변수로 전달받아서
    // BufferedImage 객체를 생성합니다.
    public GraphicObject(String name) {
        try {
            img = ImageIO.read(new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 미래에 만들어질 후손 클래스들이 가져야 할 공통적인 메서드를 만듭니다.
    public void update() {}
    public void draw(Graphics g) {
        g.drawImage(img, x, y, null);
    }
    public void keyPressed(KeyEvent event) {}

}
