package com.kosta.exam05;

public class CountDownRunnable implements Runnable {
    @Override
    public void run() {
        for (int i=20; i>=1; i--) {
            System.out.println(i + "초 전입니다.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("예외 발생: " + e.getMessage());
            }
        }
        System.out.println("발사!!");
    }

}
