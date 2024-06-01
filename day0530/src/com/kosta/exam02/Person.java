package com.kosta.exam02;

public class Person extends Thread {
    private String name;
    public Person(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(name + "이 밥을 먹어요 ==> " + i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println("예외 발생: " + e.getMessage());
            }
        }
    }
}
