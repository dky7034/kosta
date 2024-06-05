package com.kosta.chat01;

import javax.swing.*;  // 스윙 GUI 구성 요소를 사용하기 위해 임포트
import java.awt.*;  // 레이아웃 관리를 위해 임포트
import java.awt.event.ActionEvent;  // 버튼 클릭 이벤트 처리를 위해 임포트
import java.awt.event.ActionListener;  // 이벤트 리스너 처리를 위해 임포트
import java.io.*;  // 입출력 스트림을 사용하기 위해 임포트
import java.net.Socket;  // 소켓 통신을 위해 임포트
import java.util.Arrays;  // 배열 처리를 위해 임포트

public class test01 extends JFrame {

    JPanel panel;  // GUI 패널 선언
    JButton sendButton;  // 전송 버튼 선언
    JTextArea textArea;  // 텍스트 영역 선언
    JTextField textField;  // 텍스트 필드 선언
    // 서버와 통신하기 위한 소켓 생성
    Socket socket;
    // 생성된 소켓을 통해서 스트림을 생성
    InputStream in;
    OutputStream out;
    // 보낼 데이터를 위한 바이트 배열 생성
    byte[] buffer;

    public test01() {

        // 프레임 기본 설정
        setTitle("Chat Application");  // 프레임 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 닫기 버튼 클릭 시 프로그램 종료 설정
        setSize(300, 600);  // 프레임 크기 설정
        setLayout(new BorderLayout());  // 레이아웃 설정

        // 하위 패널 생성
        JPanel panel = new JPanel();  // 패널 생성
        panel.setLayout(new BorderLayout());  // 패널 레이아웃 설정
        // 하위 패널 구성 요소
        textArea = new JTextArea();  // 텍스트 영역 생성
        textArea.setEditable(false);  // 텍스트 영역 수정 불가 설정
        textArea.setLineWrap(true);  // 텍스트 자동 줄바꿈 설정
        textArea.setWrapStyleWord(true);  // 단어 단위로 줄바꿈 설정
        JScrollPane scrollPane = new JScrollPane(textArea);  // 스크롤 패널에 텍스트 영역 추가

        scrollPane.setBounds(10, 10, 450, 300);  // 스크롤 패널 위치와 크기 설정
        textField = new JTextField();  // 텍스트 필드 생성
        sendButton = new JButton("Send");  // 전송 버튼 생성

        panel.add(textField, BorderLayout.CENTER);  // 텍스트 필드를 패널 가운데에 추가
        panel.add(sendButton, BorderLayout.EAST);  // 전송 버튼을 패널 오른쪽에 추가
        this.add(textArea, BorderLayout.CENTER);  // 텍스트 영역을 프레임 가운데에 추가
        this.add(panel, BorderLayout.SOUTH);  // 패널을 프레임 아래쪽에 추가

        setVisible(true);  // 프레임을 보이게 설정
        setResizable(false);  // 프레임 크기 조정 불가 설정

        // 서버로부터 수신된 데이터를 계속해서 받기 위한 스레드 생성
        class ClientThread extends Thread {  // 클라이언트 스레드 클래스 선언
            @Override
            public void run() {  // 스레드 실행 메서드
                byte[] data = new byte[100];  // 데이터 수신을 위한 바이트 배열 생성
                try {
                    while (true) {  // 무한 루프를 돌며 데이터 수신
                        // 입력 스트림에서 데이터를 읽음
                        in.read(data);
                        // 텍스트 영역에 데이터를 추가
                        textArea.append(new String(data));
                        textArea.append("\n");  // 줄바꿈 추가
                        Arrays.fill(data, (byte) 0);  // 배열 초기화
                    }
                } catch (Exception e) {  // 예외 처리
                    System.out.println("예외 발생: " + e.getMessage());  // 예외 메시지 출력
                }
            }
        }
        ClientThread ct = new ClientThread();  // 클라이언트 스레드 인스턴스 생성
        ct.start();  // 스레드 시작

        try {
            socket = new Socket("127.0.0.1", 9004);  // 서버에 연결할 소켓 생성
            in = socket.getInputStream();  // 입력 스트림 생성
            out = socket.getOutputStream();  // 출력 스트림 생성
            // 전송 버튼에 액션 리스너 추가
            sendButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buffer = textField.getText().getBytes();  // 텍스트 필드의 텍스트를 바이트 배열로 변환
                    try {
                        out.write(buffer);  // 출력 스트림에 데이터 쓰기
                    } catch (Exception ex) {  // 예외 처리
                        System.out.println(ex.getMessage());  // 예외 메시지 출력
                    }
                }
            });
        } catch (Exception e) {  // 예외 처리
            System.out.println(e.getMessage());  // 예외 메시지 출력
        }
    }

    public static void main(String[] args) {
        new test01();  // test01 인스턴스 생성 및 실행
    }
}
