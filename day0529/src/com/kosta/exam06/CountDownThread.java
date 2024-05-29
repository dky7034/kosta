package com.kosta.exam06;

import java.util.Scanner;

public class CountDownThread extends Thread {
    private int delay;
    private String message;

    public CountDownThread(int delay, String message) {
        this.delay = delay;
        this.message = message;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(message);
    }
}
