package com.kosta.exam01;

class A {
    String title;
    int year;
}

class B extends A {
    String data;
    public void info() {
        System.out.println(title + ", " + year + ", " + data);
    }
}

public class D02Inheritance {
    public static void main(String[] args) {
        A ob1 = new A();
        B ob2 = new B(); // 힙 메모리에 생성된 ob2 객체에는 title, year, data만큼 메모리(힙메모리) 리소스가 할당됩니다.
        ob2.title = "abc";
    }
}
