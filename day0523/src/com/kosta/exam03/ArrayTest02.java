package com.kosta.exam03;

import java.util.ArrayList;

class Person {
    String name;
    int age;
    public Person () {}
    public Person (String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void sayHello () {
        System.out.println("hello, " + name);
    }
}

public class ArrayTest02 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(100);
        list.add("자바");
        list.add(true);
        list.add(new Person("홍길동", 20));
        list.add(2024);
        list.add(new Person("이순신", 21));

        for (int i = 0; i < list.size(); i++) {
            Object obj = list.get(i);
            System.out.println(obj);
        }
    }
}
