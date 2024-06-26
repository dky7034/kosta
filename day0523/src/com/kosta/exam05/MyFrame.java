package com.kosta.exam05;

import javax.swing.*;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends Frame {
    DrawPanel drawPanel;

    public MyFrame() {
        drawPanel = new DrawPanel();
        add(drawPanel);

        // 메뉴바를 생성합니다.
        MenuBar mb = new MenuBar();

        // 주메뉴 "그리기도구"를 만듭니다.
        Menu menu_draw = new Menu("DrawType");

        // 주메뉴 "그리기색상"을 만듭니다.
        Menu menu_drawColor = new Menu("DrawColor");

        // 부메뉴 "선","사각형", "원"을 만듭니다.
        MenuItem draw_line = new MenuItem("Line");
        MenuItem draw_rect = new MenuItem("Rect");
        MenuItem draw_oval = new MenuItem("Oval");

        // 부메뉴 "빨강", "파랑", "초록"을 만듭니다.
        MenuItem draw_red = new MenuItem("Red");
        MenuItem draw_blue = new MenuItem("Blue");
        MenuItem draw_green = new MenuItem("Green");

        // 주메뉴 "그리기도구"에 부메뉴 "선","사각형","원"을 담아요
        menu_draw.add(draw_line);
        menu_draw.add(draw_rect);
        menu_draw.add(draw_oval);

        // 주메뉴 "그리기색상"에 부메뉴 "빨강", "파랑", "초록"을 담아요
        menu_drawColor.add(draw_red);
        menu_drawColor.add(draw_blue);
        menu_drawColor.add(draw_green);

        // 주메뉴 "그리기도구", "그리기색상"을 메뉴바에 담아요
        mb.add(menu_draw);
        mb.add(menu_drawColor);

        // 메뉴바를 프레임에 설정합니다.
        setMenuBar(mb);

        // 메뉴 아이템에 ActionListener를 추가하여 도형 유형을 변경하도록 설정합니다.
        draw_line.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("선 그리기 선택");
                drawPanel.drawType = 0;
            }
        });
        draw_rect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("사각형 그리기 선택");
                drawPanel.drawType = 1;
            }
        });
        draw_oval.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("원 그리기 선택");
                drawPanel.drawType = 2;
            }
        });

        // 메뉴 아이템에 ActionListener를 추가하여 도형 색상을 변경하도록 설정합니다.
        draw_red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("빨강 선택");
                drawPanel.drawColor = 0;
            }
        });
        draw_blue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("파랑 선택");
                drawPanel.drawColor = 1;
            }
        });
        draw_green.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("초록 선택");
                drawPanel.drawColor = 2;
            }
        });

        // 기본 설정 추가
        setTitle("Drawing Application");
        setSize(700, 500);
        setVisible(true);

        // 자바에서는 클래스 안에 클래스를 만들 수 있습니다.
//        class MyLineEvent implements ActionListener {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("선 그리기를 눌렀어요!");
//            }
//        }
//        MyLineEvent myLineEvent = new MyLineEvent();
//        draw_line.addActionListener(myLineEvent);

    }

}
