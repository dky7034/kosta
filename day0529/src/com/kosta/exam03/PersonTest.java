package com.kosta.exam03;

public class PersonTest {
    public static void main(String[] args) {
        Person kim = new Person("김유신");
        Person lee = new Person("이순신");

        Thread tr1 = new Thread(kim);
        Thread tr2 = new Thread(lee);
        tr1.start();
        tr2.start();

        (new Thread(kim)).start();
        (new Thread(lee)).start();

        kim.run();
        lee.run();
    }
}
