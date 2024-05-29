package com.kosta.exam01;

public class Person {
    private String name;
    public Person() {}
    public Person(String name) {
        super();
        this.name = name;
    }
    public void sayHello() {
        try {
            for (int i = 0; i <= 10; i++) {
                System.out.println("hello, " + name + "==>" + i);
                // 지연 발생
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}
