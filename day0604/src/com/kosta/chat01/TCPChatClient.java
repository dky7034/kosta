package com.kosta.chat01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.util.Arrays;

public class TCPChatClient extends JFrame {

    JPanel panel;  // GUI 패널 선언
    JButton sendButton;  // 전송 버튼 선언
    JTextArea textArea;  // 텍스트 영역 선언
    JTextField textField;  // 텍스트 필드 선언
    Socket socket;  // 서버와 통신하기 위한 소켓 생성
    InputStream in;  // 입력 스트림 선언
    OutputStream out;  // 출력 스트림 선언
    byte[] buffer;  // 데이터를 담기 위한 바이트 배열 선언

    public TCPChatClient() {

        // Frame 기본 설정
        setTitle("Chat Application");  // 프레임 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 닫기 버튼 클릭 시 프로그램 종료 설정
        setSize(300, 600);  // 프레임 크기 설정
        setLayout(new BorderLayout());  // 레이아웃 설정

        // 하위 패널 생성
        panel = new JPanel();  // 패널 생성
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

        try {
            socket = new Socket("127.0.0.1", 9004);  // 서버에 연결할 소켓 생성
            in = socket.getInputStream();  // 입력 스트림 생성
            out = socket.getOutputStream();  // 출력 스트림 생성
        } catch (IOException e) {
            System.out.println("Error initializing socket or streams: " + e.getMessage());
            return;
        }

        // 서버로부터 수신된 데이터를 계속해서 받기 위한 스레드 생성
        class ClientThread extends Thread {  // 클라이언트 스레드 클래스 선언
            @Override
            public void run() {  // 스레드 실행 메서드
                byte[] data = new byte[100];  // 데이터 수신을 위한 바이트 배열 생성
                try {
                    while (true) {  // 무한 루프를 돌며 데이터 수신
                        int bytesRead = in.read(data);  // 입력 스트림에서 데이터 읽기
                        if (bytesRead == -1) break;  // EOF 처리
                        textArea.append(new String(data, 0, bytesRead));  // 텍스트 영역에 데이터 추가
                        textArea.append("\n");  // 줄바꿈 추가
                        Arrays.fill(data, (byte) 0);  // 배열 초기화
                    }
                } catch (IOException e) {  // 예외 처리
                    System.out.println("Exception in reading data: " + e.getMessage());
                }
            }
        }

        ClientThread ct = new ClientThread();  // 클라이언트 스레드 인스턴스 생성
        ct.start();  // 스레드 시작

        // Send 버튼의 액션 리스너
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {  // 버튼 클릭 시 실행되는 메서드
                buffer = textField.getText().getBytes();  // 텍스트 필드의 텍스트를 바이트 배열로 변환
                try {
                    out.write(buffer);  // 출력 스트림에 데이터 쓰기
                    textField.setText("");  // 메시지를 보낸 후 텍스트 필드를 비움
                } catch (IOException ex) {  // 예외 처리
                    System.out.println("Exception in writing data: " + ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        new TCPChatClient();  // TCPChatClient 인스턴스 생성 및 실행
    }
}
