package com.kosta.exam06;

public class CountDownRunnable implements Runnable {
    private int delay;
    private String message;
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
