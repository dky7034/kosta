package com.kosta.gamegame;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MyPanel extends JPanel implements KeyListener {
    // 이미지 파일을 참조하기 위한 변수 선언
    BufferedImage img = null;

    // 이미지의 현재 위치를 저장할 변수
    int imgX = 100;
    int imgY = 100;

    public MyPanel() {
        // 이미지를 표현하기 위한 BufferedImage 객체를 생성합니다.
        try {
            img = ImageIO.read(new File("/Users/donggyun/intellij-workspace/kosta/day0529/src/com/kosta/gamegame/resized-img/enemy.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 키보드 이벤트 등록
        addKeyListener(this);

        // 패널은 원래부터 어떤 글자를 입력하는 용도가 아닙니다.
        // 그래서 키보드 이벤트를 등록해도 동작하지 않습니다.
        // 패널에 키보드 이벤트를 등록하려면
        // 포커스를 설정해야 합니다.
        setFocusable(true);
        requestFocusInWindow();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//        g.drawImage(img, imgX, imgY, null);
        if (img != null) {
            g.drawImage(img, imgX, imgY, null);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // 구현이 필요 없으면 비워 둡니다.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                imgX -= 10;
                break;
            case KeyEvent.VK_UP:
                imgY -= 10;
                break;
            case KeyEvent.VK_RIGHT:
                imgX += 10;
                break;
            case KeyEvent.VK_DOWN:
                imgY += 10;
                break;
        }
        // 이미지 위치가 변경되었으므로 패널을 다시 그립니다.
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // 구현이 필요 없으면 비워 둡니다.
    }

    public static void main(String[] args) {
        javax.swing.JFrame frame = new javax.swing.JFrame();
        MyPanel panel = new MyPanel();
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
