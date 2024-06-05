package com.kosta.tcp01;

import java.io.InputStream;
import java.net.Socket;

public class TCPClient01 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("172.30.1.69", 9001);
            InputStream is = socket.getInputStream();
            for (int i = 1; i <= 10; i++) {
                int n = is.read();
                System.out.println("서버로부터 수신된 데이터 : " + n);
            }

            is.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("예외발생:" + e.getMessage());
        }
    }
}