package com.kosta.exam03;

import java.util.ArrayList;

class  Human {
    String name;
    int age;
    public Human(String name, int age) {this.name = name; this.age = age;}
    public void sayHello() {
        System.out.println("Hello "+ name + "(" + age + "살)");
    }
}
public class ArrayTest03 {
    public static void main(String[] args) {
        ArrayList<Human> list = new ArrayList<>();
        list.add(new Human("홍길동", 20));
        list.add(new Human("홍석영",21));
        // 리스트에는 Human 타입만 저장할 수 있습니다.
//        list.add(100);
        for (Human h : list) {
            h.sayHello();
        }
    }
}
