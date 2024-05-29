package com.kosta.exam05;

public class CountDownEvent {
    public static void main(String[] args) {
        CountDownRunnable runnable = new CountDownRunnable();
        (new Thread(runnable)).start();
//        CountDownThread thread = new CountDownThread();
//        thread.start();
    }
}
