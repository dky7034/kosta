package com.kosta.homework02;

public class Dog {
    private String name;
    public String breed;
    private int age;

    // getter and setter
    public String getName() {return name;}
    public String getBreed() {return breed;}
    public int getAge() {return age;}
    public void setName(String name) {this.name = name;}
    public void setBreed(String breed) {this.breed = breed;}
    public void setAge(int age) {this.age = age;}
    
    // 생성자
    public Dog() {}
    public Dog(String name, String breed, int age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
    }
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
