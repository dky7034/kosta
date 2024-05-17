package com.kosta.exam13;

class Person {
    private String name;
    private int age;
    private double height;
    
    // 생성자
    public Person() {}
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
    }
}
