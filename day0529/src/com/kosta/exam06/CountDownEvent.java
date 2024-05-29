package com.kosta.exam06;

public class CountDownEvent {
    public static void main(String[] args) {
        CountDownThread countDownThread = new CountDownThread(1000, "hello");

        countDownThread.start();
    }
}
