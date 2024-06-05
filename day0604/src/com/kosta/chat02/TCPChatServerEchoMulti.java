package com.kosta.chat02;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

class ServerThread extends Thread {
    // 변수
    Socket socket;
    InputStream is;
    OutputStream os;

    // 생성자
    public ServerThread(Socket socket) {
        try {
            // 연결된 클라이언트와 데이터를 주고받기 위한 입출력 스트림을 생성
            is = socket.getInputStream();  // 입력 스트림 생성
            os = socket.getOutputStream();  // 출력 스트림 생성
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }

    // run() 메서드 오버라이딩
    @Override
    public void run() {
        // 클라이언트로부터 수신된 데이터를 받기 위한 배열을 만듦
        byte[] data = new byte[100];
        try {
            // 클라이언트와 연결된 상태에서 계속 통신
            while (true) {
                is.read(data);  // 수신된 데이터를 읽음
                os.write(data);  // 수신된 데이터를 그대로 클라이언트에게 보냄 (메아리)
                String msg = new String(data);  // 수신된 데이터를 문자열로 변환
                System.out.println("수신된 데이터 ==> " + msg);  // 수신된 데이터를 콘솔에 출력
                Arrays.fill(data, (byte) 0);  // 배열 초기화
            }
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}

public class TCPChatServerEchoMulti {
    public static void main(String[] args) {
        // 1. ServerSocket을 생성한다.
        try {
            ServerSocket server = new ServerSocket(9003);
            System.out.println("서버가 포트 9003에서 대기 중입니다...");

            // 클라이언트의 접속을 무한 대기 상태로 기다린다.
            while (true) {
                // 클라이언트 접속을 수락한다.
                Socket socket = server.accept();
                System.out.println("새 클라이언트가 연결되었습니다.");

                // 연결된 클라이언트를 상대하여 계속 통신할 스레드를 생성한다.
                ServerThread st = new ServerThread(socket);

                // 스레드를 가동 시킨다.
                st.start();
            }
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}
