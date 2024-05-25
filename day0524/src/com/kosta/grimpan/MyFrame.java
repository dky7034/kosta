package com.kosta.grimpan;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

// MyFrame 클래스는 Frame을 상속받아 GUI 컴포넌트를 설정합니다.
public class MyFrame extends Frame {
    // DrawPanel 클래스: 실제로 그림을 그리는 클래스
    DrawPanel drawPanel;

    // View
    public MyFrame() {
        // MyFrame 객체 생성 시 실제로 그림을 그리는 클래스인 drawPanel 클래스 객체도 생성합니다.
        drawPanel = new DrawPanel();
        add(drawPanel);

        // 메뉴바를 생성합니다.
        MenuBar mb = new MenuBar();

        // 주메뉴 "파일"을 만듭니다.
        Menu menu_file = new Menu("File");

        // 주메뉴 "그리기도구"를 만듭니다.
        Menu menu_draw = new Menu("DrawType");

        // 주메뉴 "그리기색상"을 만듭니다.
        Menu menu_drawColor = new Menu("DrawColor");

        // 부메뉴 "열기", "저장"
        MenuItem open_file = new MenuItem("Open");
        MenuItem save_file = new MenuItem("Save");

        // 부메뉴 "선","사각형", "원"을 만듭니다.
        MenuItem draw_line = new MenuItem("Line");
        MenuItem draw_rect = new MenuItem("Rect");
        MenuItem draw_oval = new MenuItem("Oval");

        // 부메뉴 "빨강", "파랑", "초록"을 만듭니다.
        MenuItem draw_red = new MenuItem("Red");
        MenuItem draw_blue = new MenuItem("Blue");
        MenuItem draw_green = new MenuItem("Green");

        // 주메뉴 "파일"에 "열기", "저장"을 담아요.
        menu_file.add(open_file);
        menu_file.add(save_file);

        // 주메뉴 "그리기도구"에 부메뉴 "선","사각형","원"을 담아요
        menu_draw.add(draw_line);
        menu_draw.add(draw_rect);
        menu_draw.add(draw_oval);

        // 주메뉴 "그리기색상"에 부메뉴 "빨강", "파랑", "초록"을 담아요
        menu_drawColor.add(draw_red);
        menu_drawColor.add(draw_blue);
        menu_drawColor.add(draw_green);

        // 주메뉴 "파일", "그리기도구", "그리기색상"을 메뉴바에 담아요
        mb.add(menu_file);
        mb.add(menu_draw);
        mb.add(menu_drawColor);

        // 메뉴바를 프레임에 설정합니다.
        setMenuBar(mb);

        // 메뉴 아이템에 기능을 추가하는 코드
        // 메뉴 아이템에 ActionListener를 추가하여 도형 유형을 변경하도록 설정합니다.
        // 도형 유형 메뉴에 기능을 추가
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
        // 도형 색상 메뉴에 기능을 추가
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

        // 메뉴 아이템에 ActionListener를 추가하여 파일을 열고, 저장하도록 설정합니다.
        // 파일 저장 메뉴에 기능을 추가
        // 파일 저장에 대한 이벤트 처리
        save_file.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // ObjectOutputStream 객체를 생성하여 객체 단위로 데이터를 출력합니다.
                    // FileOutputStream 객체를 매개변수로 전달하여 저장할 파일의 위치와 이름을 지정합니다.
                    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("/Users/donggyun/Downloads/data/bus.pan"));

                    // drawPanel의 리스트에 담긴 객체들을 파일에 저장합니다.
                    oos.writeObject(drawPanel.list);

                    // 사용이 끝난 ObjectOutputStream 객체를 닫아 자원을 해제합니다.
                    oos.close();
                } catch (IOException ex) {
                    // IOException이 발생할 경우 런타임 예외로 변환하여 처리합니다.
                    throw new RuntimeException(ex);
                }
            }
        });
        // 파일 열기에 대한 이벤트 처리
        open_file.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // ObjectInputStream 객체를 생성하여 객체 단위로 데이터를 입력받습니다.
                    // FileInputStream 객체를 매개변수로 전달하여 읽어올 파일의 위치와 이름을 지정합니다.
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/Users/donggyun/Downloads/data/bus.pan"));

                    // 파일로부터 객체를 읽어와 drawPanel의 리스트에 저장합니다.
                    drawPanel.list = (ArrayList<GraphicInfo>) ois.readObject();

                    // drawPanel의 리스트에 담긴 내용을 기반으로 그래픽을 다시 그리도록 요청합니다.
                    drawPanel.repaint();

                    // 사용이 끝난 ObjectInputStream 객체를 닫아 자원을 해제합니다.
                    ois.close();
                } catch (IOException ex) {
                    // IOException이 발생할 경우 런타임 예외로 변환하여 처리합니다.
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    // ClassNotFoundException이 발생할 경우 런타임 예외로 변환하여 처리합니다.
                    throw new RuntimeException(ex);
                }
            }
        });

        // 기본 설정 추가
        // 프레임(창)의 제목, 크기 등 설정
        setTitle("Drawing Application");
        setSize(700, 500);
        setVisible(true);

    }

}
