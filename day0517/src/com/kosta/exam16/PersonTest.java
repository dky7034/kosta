package com.kosta.exam16;

class Person {
    private String name;
    private int age;
    private double height;

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

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // 생성자
    public Person(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }
    public Person() {}
}

public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person();
        System.out.println("name: " + p1.getName());
        System.out.println("age: " + p1.getAge());
        System.out.println("height: " + p1.getHeight());

        Person p2 = new Person("james", 35, 205.8);
        System.out.println("p2.getName() = " + p2.getName());
        System.out.println("p2.getAge() = " + p2.getAge());
        System.out.println("p2.getHeight() = " + p2.getHeight());
    }

}
