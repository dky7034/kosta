package com.kosta.exam03;


// 스레드 클래스 생성(Runnable 인터페이스 구현)
public class Person implements Runnable {
    public String name;
    public Person(String name) {
        super();
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("hello " + name + "==>" + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("예외 발생: " + e.getMessage());
            }
        }

    }
}
