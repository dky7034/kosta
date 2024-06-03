package com.kosta.exam02;

import javax.swing.*; // Java Swing 패키지를 임포트
import java.awt.*; // Java AWT 패키지를 임포트
import java.awt.event.MouseAdapter; // MouseAdapter 클래스를 임포트
import java.awt.event.MouseEvent; // MouseEvent 클래스를 임포트
import java.awt.event.MouseListener; // MouseListener 인터페이스를 임포트
import java.io.File; // File 클래스를 임포트
import java.io.FileReader; // FileReader 클래스를 임포트
import java.util.Vector; // Vector 클래스를 임포트

public class FileTest03 extends JFrame { // FileTest03 클래스는 JFrame을 상속받음
    // 변수 선언
    JList<String> list; // 파일 목록을 표시할 JList
    JTextArea jta; // 파일 내용을 표시할 JTextArea
    Vector<String> v; // 파일 이름을 저장할 벡터
    File file = new File("/Users/donggyun/data"); // 파일 객체를 생성하여 디렉토리 경로 설정

    // 생성자
    public FileTest03() {
        v = new Vector<String>(); // 벡터 초기화
        // 디렉토리의 파일 목록을 배열에 저장
        String[] file_arr = file.list(); // 파일 목록을 배열에 저장

        // 파일 배열이 null이 아닌 경우에만 실행
        if (file_arr != null) {
            for (String file_name : file_arr) { // 배열의 각 파일 이름에 대해 반복
                // 파일 이름이 .txt 또는 .java로 끝나는 경우 벡터에 추가
                if (file_name.endsWith(".txt") || file_name.endsWith(".java")) {
                    v.add(file_name); // 벡터에 파일 이름 추가
                }
            }
        }

        list = new JList<String>(v); // 벡터를 기반으로 JList 생성
        JScrollPane jsp_list = new JScrollPane(list); // JList를 JScrollPane에 추가

        jta = new JTextArea(); // JTextArea 생성
        JScrollPane jsp_jta = new JScrollPane(jta); // JTextArea를 JScrollPane에 추가

        add(jsp_list, BorderLayout.WEST); // JScrollPane(JList)를 프레임의 서쪽에 추가
        add(jsp_jta, BorderLayout.CENTER); // JScrollPane(JTextArea)를 프레임의 중앙에 추가

        setSize(400, 300); // 프레임 크기 설정
        setVisible(true); // 프레임을 화면에 표시
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임의 닫기 버튼을 클릭할 때 프로그램 종료

        // JList에 마우스 리스너 추가
        list.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) { // 마우스 클릭 이벤트 처리
                int cnt = e.getClickCount(); // 클릭 횟수 가져오기
                if (cnt == 2) { // 더블 클릭인 경우
                    String selectedFileName = list.getSelectedValue(); // 선택된 파일 이름 가져오기
                    if (selectedFileName != null) { // 선택된 파일 이름이 null이 아닌 경우
                        File file = new File("/Users/donggyun/data/" + selectedFileName); // 파일 객체 생성
                        file.delete(); // 파일 삭제
                        jta.setText(""); // JTextArea 내용 비우기
                        File dir = new File("/Users/donggyun/data"); // 디렉토리 객체 생성
                        String[] arr = dir.list(); // 디렉토리의 파일 목록 가져오기

                        // 벡터를 깨끗이 비워줌
                        v.clear(); // 벡터 초기화
                        // 파일 목록을 새로 갱신
                        if (arr != null) { // 파일 배열이 null이 아닌 경우
                            for (String fname : arr) { // 배열의 각 파일 이름에 대해 반복
                                // 파일 이름이 .txt 또는 .java로 끝나는 경우 벡터에 추가
                                if (fname.endsWith(".txt") || fname.endsWith(".java")) {
                                    v.add(fname); // 벡터에 파일 이름 추가
                                }
                            }
                        }

                        // 벡터의 내용이 바뀌었으니 리스트를 다시 그려줄 것을 요청
                        list.updateUI(); // JList 갱신
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) { // 마우스 버튼이 눌렸을 때 처리

            }

            @Override
            public void mouseReleased(MouseEvent e) { // 마우스 버튼이 떼어졌을 때 처리
                String file_name = list.getSelectedValue(); // 선택된 파일 이름 가져오기
                if (file_name != null) { // 파일 이름이 null이 아닌 경우
                    FileReader fr = null; // FileReader 객체 선언
                    try {
                        fr = new FileReader("/Users/donggyun/data/" + file_name); // FileReader 객체 생성
                        int ch; // 문자 데이터를 저장할 변수
                        StringBuilder data = new StringBuilder(); // 문자열 데이터를 저장할 StringBuilder 객체
                        while ((ch = fr.read()) != -1) { // 파일 끝까지 읽기
                            data.append((char) ch); // 읽은 문자 데이터를 StringBuilder에 추가
                        }
                        jta.setText(data.toString()); // JTextArea에 파일 내용 설정
                    } catch (Exception ex) {
                        System.out.println("예외 발생: " + ex.getMessage()); // 예외 메시지 출력
                    } finally {
                        if (fr != null) { // FileReader 객체가 null이 아닌 경우
                            try {
                                fr.close(); // FileReader 객체 닫기
                            } catch (Exception ex) {
                                System.out.println("예외 발생: " + ex.getMessage()); // 예외 메시지 출력
                            }
                        }
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) { // 마우스가 컴포넌트에 들어갔을 때 처리

            }

            @Override
            public void mouseExited(MouseEvent e) { // 마우스가 컴포넌트를 나갔을 때 처리

            }
        });
    }

    public static void main(String[] args) {
        new FileTest03(); // FileTest03 객체 생성 및 실행
    }
}
