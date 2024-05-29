package com.kosta.exam07;

public class CountDownThread extends Thread {
    private int delay;
    private String message;

    public CountDownThread(int delay, String message) {
        super();
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
