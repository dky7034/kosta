package com.kosta.udp01; // 패키지 이름: com.kosta.udp01

import java.net.DatagramPacket; // UDP 데이터 패킷을 위한 클래스
import java.net.DatagramSocket; // UDP 소켓을 위한 클래스
import java.net.SocketException; // 소켓 관련 예외 처리를 위한 클래스
import java.util.Arrays; // 배열 관련 유틸리티 클래스

public class UDPReceiver { // UDP 수신기 클래스

    public static void main(String[] args) { // 메인 메서드
        try { // 예외 처리 시작

            // UDP 소켓 생성 (포트 번호 9002 사용)
            DatagramSocket socket = new DatagramSocket(9002);

            // 데이터 저장을 위한 바이트 배열 (100바이트 크기)
            byte[] data = new byte[100];

            // UDP 데이터 패킷 생성 (데이터 배열, 데이터 길이)
            DatagramPacket packet = new DatagramPacket(data, data.length);

            // 무한 루프 시작
            while (true) {
                // UDP 데이터 패킷 수신
                socket.receive(packet);

                // 수신된 데이터를 문자열 변환
                String msg = new String(data);

                // 수신된 데이터 출력
                System.out.println("수신된 데이터 : " + msg);

                // 데이터 배열 초기화
                Arrays.fill(data, (byte) 0);
            }

        } catch (Exception e) { // 예외 처리
            System.out.println("예외 발생:" + e.getMessage());
        }
    }
}
