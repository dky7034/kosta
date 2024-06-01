package com.kosta.gamegamegame;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;

// JPanel을 상속받고 KeyListener 인터페이스를 구현하는 MyPanel 클래스를 만듭니다.
public class MyPanel extends JPanel implements KeyListener {
    // 게임 구성 요소인 적, 플레이어, 미사일을 멤버변수로 선언합니다.
    Enemy enemy;
    Player player;
    // 미사일을 여러 개 생성하기 위해 리스트로 변수를 선언합니다.
    ArrayList<Missile> missileList;

    // 생성자
    public MyPanel() {
        // 부모 생성자를 자동으로 호출합니다.
        super();
        // 키보드 이벤트가 발생하였을 때 이벤트 처리를 담당할 객체를 설정합니다.
        addKeyListener(this);
        // 패널은 기본적으로 키보드 이벤트를 받을 수 없으므로 포커스를 설정합니다.
        requestFocus();
        setFocusable(true);

        // 적, 플레이어, 미사일 객체를 각각 생성합니다. 생성 시에 이미지 파일명을 전달합니다.
        enemy = new Enemy("/Users/donggyun/intellij-workspace/kosta/day0529/src/com/kosta/enemy.png");
        player = new Player("/Users/donggyun/intellij-workspace/kosta/day0529/src/com/kosta/jejus.jpeg");
//        missile = new Missile("/Users/donggyun/intellij-workspace/kosta/day0529/src/com/kosta/thunder02.png");
        // 미사일 객체는 리스트로 생성합니다.
        missileList = new ArrayList<>();

        // 게임 객체들의 위치를 업데이트하는 스레드를 시작합니다.
        MyThread thread = new MyThread();
        thread.start();
    }

    // 적, 미사일, 플레이어가 각각 동시다발적으로 움직이게 하기 위해서 스레드 클래스를 만듭니다.
    // 이 클래스는 다른 곳에서는 사용되지 않기 때문에 Inner 클래스로 만듭니다.
    class MyThread extends Thread {
        public void run() {
            while (true) {
                // 각 객체의 위치를 업데이트합니다.
                enemy.update();
                player.update();
//                missile.update();
                // 미사일 리스트의 각 미사일을 업데이트합니다.
                for (Missile missile : missileList) {
                    missile.update();
                }
                // 화면을 다시 그리도록 요청합니다.
                repaint();

                // 적이 맞았는지 여부를 확인하여 충돌 상태를 설정합니다.
                for (Missile missile : missileList) {
                    if (enemy.isHit(missile)) {
                        break;
                    }
                }

                // 0.035초 동안 일시 중지하여 애니메이션 속도를 조절합니다.
                try {
                    Thread.sleep(35);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // JPanel의 paint 메서드를 오버라이드하여 게임 객체들을 그립니다.
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        enemy.draw(g);
        player.draw(g);
//        missile.draw(g);
        for (Missile missile : missileList) {
            missile.draw(g);
        }
    }

    // 스레드에서 각 그래픽 오브젝트의 위치를 변경시킨 후 repaint를 호출하면 이 메서드가 동작합니다.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        enemy.draw(g);
        player.draw(g);
//        missile.draw(g);
        for (Missile missile : missileList) {
            missile.draw(g);
        }
    }

    // 키보드 키가 눌러졌을 때 호출되는 메서드
    @Override
    public void keyTyped(KeyEvent e) {
        // 사용되지 않음
    }

    // 키보드 키가 눌러졌을 때 호출되는 메서드
    @Override
    public void keyPressed(KeyEvent e) {
        // 플레이어의 keyPressed 메서드를 호출하면서 키 이벤트를 전달합니다.
        player.keyPressed(e);
        // 미사일의 keyPressed 메서드를 호출하면서 키 이벤트와 플레이어의 위치(x, y)를 전달합니다.
//        missile.keyPressed(e, player.x, player.y);
        // 스페이스 키를 눌렀을 때 새로운 미사일을 발사합니다.
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            Missile missile = new Missile("/Users/donggyun/intellij-workspace/kosta/day0529/src/com/kosta/thunder02.png");
            missile.keyPressed(e, player.x, player.y);
            missileList.add(missile);
        }
    }

    // 키보드 키가 놓였을 때 호출되는 메서드
    @Override
    public void keyReleased(KeyEvent e) {
        // 사용되지 않음
    }
}
