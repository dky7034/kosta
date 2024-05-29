package com.kosta.exam07;

public class MainTest {
    public static void main(String[] args) {
        CountDownRunnable countDownRunnable = new CountDownRunnable();
        CountDownThread countDownThread = new CountDownThread(2000, "연결 장치 분리!!");
        (new Thread(countDownRunnable)).start();
        countDownThread.start();
    }
}
