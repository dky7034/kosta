package com.kosta.exam02;

class Person {
    String name;
    int age;
    public void sayHello() {
        System.out.println("hello, " + name);
    }
}

class Student extends Person {
    String major;
    public void study() {
        System.out.println("study " + major);
    }
}

public class FinalTest {
    public static void main(String[] args) {

    }
}
