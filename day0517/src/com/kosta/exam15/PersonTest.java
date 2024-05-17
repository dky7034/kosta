package com.kosta.exam15;

class Person {
    private String name;
    private int age;
    private double height;
    
    // 생성자
    public Person() {} //=> 기본생성자
    public Person(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }
    
    // getter
    public String getName() {return name;}
    public int getAge() {return age;}
    public double getHeight() {return height;}

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
