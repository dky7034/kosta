package com.kosta.chat01;

import java.io.InputStream;  // 입력 스트림을 사용하기 위해 임포트
import java.io.OutputStream;  // 출력 스트림을 사용하기 위해 임포트
import java.net.ServerSocket;  // 서버 소켓을 사용하기 위해 임포트
import java.net.Socket;  // 소켓을 사용하기 위해 임포트
import java.util.Arrays;  // 배열 처리를 위해 임포트

public class TCPChatServer {
    public static void main(String[] args) {
        // 클라이언트로부터 수신된 데이터를 받기 위한 배열을 만듦
        byte[] data = new byte[100];

        try {
            ServerSocket serverSocket = new ServerSocket(9004);  // 서버 소켓을 생성하여 포트 9003에서 대기
            // 클라이언트의 접속을 무한 대기상태로 함
            while (true) {
                Socket socket = serverSocket.accept();  // 클라이언트의 연결을 수락
                // 연결된 클라이언트와 데이터를 주고받기 위한 입출력 스트림을 생성
                InputStream is = socket.getInputStream();  // 입력 스트림 생성
                OutputStream os = socket.getOutputStream();  // 출력 스트림 생성

                // 연결된 클라이언트와 계속 통신
                while (true) {
                    int bytesRead = is.read(data);  // 수신된 데이터를 읽음
                    if (bytesRead == -1) break;  // 클라이언트 연결 종료 시 루프 탈출
                    os.write(data, 0, bytesRead);  // 수신된 데이터를 그대로 클라이언트에게 보냄 (메아리)
                    String msg = new String(data, 0, bytesRead);  // 수신된 데이터를 문자열로 변환
                    System.out.println("수신된 데이터 ==> " + msg);  // 수신된 데이터를 콘솔에 출력
                    Arrays.fill(data, (byte) 0);  // 배열 초기화
                }
//                socket.close();  // 클라이언트 소켓을 닫음
            }
        } catch (Exception e) {
            System.out.println("예외 발생:" + e.getMessage());  // 예외 발생 시 메시지 출력
        }
    }
}
