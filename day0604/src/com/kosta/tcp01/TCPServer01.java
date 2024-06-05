package com.kosta.tcp01;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TCPServer01 {
    public static void main(String[] args) {
        Random r = new Random();
        try {
            ServerSocket server = new ServerSocket(9001);
            System.out.println("통신 준비 완료!!");

            while (true) {
                Socket socket = server.accept();
                System.out.println("*** 클라이언트가 연결하였습니다 ****");
                OutputStream os = socket.getOutputStream();

                for (int i = 1; i <= 10; i++) {
                    int n = r.nextInt(100) + 1;
                    os.write(n);
                    Thread.sleep(200);
                }
                System.out.println("데이터 전송 완료!");
                os.close();
                socket.close();
                server.close();
            }

        } catch (Exception e) {
            System.out.println("예외발생:" + e.getMessage());
        }
    }
}