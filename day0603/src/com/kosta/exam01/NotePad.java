package com.kosta.exam01;

import javax.swing.*;

public class NotePad extends JFrame {
    // 텍스트가 입력되는 공간
    JTextArea jta;
    // 생성자
    public NotePad() {
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
    }

    // 메인 메서드
    public static void main(String[] args) {
        new NotePad();
    }

}
