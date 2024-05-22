package com.kosta.exam04;

import java.util.Objects;

public class Person {
    private String name;
    private int age;

    // equals override
//    @Override
//    public boolean equals(Object obj) {
//        boolean re = false;
//        Person p = (Person) obj; // 부모의 참조변수가 자식에 추가된 속성에 접근하기 위한 형변환
//        // equals()는 Object 부모클래스이고, Person은 자식클래스임.
//        if (name.equals(p.name) && age == p.age) {
//            re = true;
//        }
//        return re;
//    }

    // equals override (자동생성)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }
    // hashCode override (자동생성)
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    // 생성자
    public Person() {}
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // toString
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
