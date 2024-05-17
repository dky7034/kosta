package com.kosta.exam24;

public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person("홍길동", 20);
        Person p2 = new Person();

//        System.out.println("이름: " + p2.getName());
//        System.out.println("나이: " + p2.getAge());
//        System.out.println("이름: " + p1.getName());
//        System.out.println("나이: " + p1.getAge());

//        p1.info();
//        p2.info();

        String data1 = p1.getInfo();
        String data2 = p2.getInfo();

        System.out.println(data1);
        System.out.println(p2.getInfo());

    }
}