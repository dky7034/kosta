package com.kosta.exam01;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;

public class NotePad02 extends JFrame {
    // 텍스트가 입력되는 공간
    JTextArea jta;
    // 생성자
    public NotePad02() {
        // 제목 설정
//        setTitle("메모장");
        super("메모장");
        // 생성자 호출 시 텍스트를 입력하는 JTextArea 객체 생성
        jta = new JTextArea();
        // TextArea에 스크롤바를 감싸는 역할을 함
        JScrollPane jsp = new JScrollPane(jta);
        add(jsp);

        // 메뉴바 만들기
        JMenuBar jmb = new JMenuBar();
        // 주 메뉴
        JMenu mn_file = new JMenu("File");
        // 부 메뉴
        JMenuItem fine_new = new JMenuItem("새 파일");
        JMenuItem file_open = new JMenuItem("열기");
        JMenuItem fine_save = new JMenuItem("저장");

        // 주 메뉴에 부 메뉴 추가
        mn_file.add(fine_new);
        mn_file.add(file_open);
        mn_file.add(fine_save);

        // 메뉴바에 주 메뉴 추가
        jmb.add(mn_file);

        // 프레임에 메뉴바를 추가(설정)
        setJMenuBar(jmb);

        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 부 메뉴에 이벤트 리스너 등록
        // 새 파일
        fine_new.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        // 열기
        file_open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // 텍스트 파일을 읽어오는 방법:
                    FileReader fr = new FileReader("/Users/donggyun/data/note.txt");
                    // 파일로부터 한 문자를 읽어서 변수 ch에 저장
                    int ch;
                    StringBuffer data = new StringBuffer();
                    // 파일을 끝까지 읽기 위한 반복문
                    while ((ch = fr.read()) != -1) {
                        data.append((char) ch);
                    }
                    jta.setText(data.toString());
                    // 텍스트 필드에 읽어들인 문자열을 설정
                } catch (Exception exception) {
                    System.out.println("예외 발생: " + exception.getMessage());
                }

            }
        });
        // 저장
        fine_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TextArea에 입력된 텍스트를 가져와서 변수 data에 저장
                String data = jta.getText();
                System.out.println(data);

                try {
                    // 텍스트 파일을 기록하는 방법:
                    FileWriter fw = new FileWriter("/Users/donggyun/data/note.txt");
                    fw.write(data);
                    fw.close();
                } catch (Exception exception) {
                    System.out.println("예외 발생: " + exception.getMessage());
                }

            }
        });
    }

    // 메인 메서드
    public static void main(String[] args) {
        new NotePad02();
    }

}
