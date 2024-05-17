package com.kosta.exam25;

public class Person {
    private String name;
    private int age;

    // getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    // 생성자
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Person() {}

    // 메서드
    // Person의 모든 속성 정보를 출력하는 메서드
    public void info() {
        System.out.println("이름은 " + name + "입니다.");
        System.out.println("나이는 " + age + "살입니다.");
    }
    public String getInfo() {
        String result = "이름: " + name + ", 나이: " + age;
        return result;
    }

}