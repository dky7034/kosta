package com.kosta.chat03;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
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

    // 나와 연결된 클라이언트에게 메시지를 보내는 메서드
    public void send(byte[] arr) throws Exception {
        os.write(arr);
    }

    // 연결된 모든 클라이언트에게 메시지를 방송하는 메서드
    public void sendAll(byte[] arr) throws Exception {
        for (ServerThread st : TCPChatServerBroadCastMulti.list) {
            st.send(arr);
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
                sendAll(data);  // 연결된 모든 클라이언트에게 방송
                String msg = new String(data);  // 수신된 데이터를 문자열로 변환
                System.out.println("수신된 데이터 ==> " + msg);  // 수신된 데이터를 콘솔에 출력
                Arrays.fill(data, (byte) 0);  // 배열 초기화
            }
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}

public class TCPChatServerBroadCastMulti {

    // 연결된 클라이언트들을 관리할 ServerThread 리스트를 선언
    public static ArrayList<ServerThread> list;

    public static void main(String[] args) {
        // 리스트 생성
        list = new ArrayList<ServerThread>();

        // ServerSocket을 생성한다.
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

                // 생성된 스레드를 리스트에 추가한다.
                list.add(st);
            }

        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}
// 172.30.1.39
