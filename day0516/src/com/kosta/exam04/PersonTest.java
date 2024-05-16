package com.kosta.exam04;

class Person {
    private String name;
    private String gender;
    private int age;

    // setter 메서드
    public void setName(String n) {
        name = n;
    }
    public void setGender(String g) {
        gender = g;
    }
    public void setAge(int a) {
        age = a;
    }
    // getter 메서드
    public String getName() {
        return name;
    }
    public String getGender() {
        return gender;
    }
    public int getAge() {
        return age;
    }

    public void eat(String food) {
        System.out.printf("%s %d살 %s이(가) %s를(을) 먹어요\n",
                            gender, age, name, food);
    }
    public void walk(String where) {
        System.out.printf("%s %d살 %s씨는 %s 방향으로 걷습니다", gender, age, name, where);
    }
}

public class PersonTest {
    public static void main(String[] args) {
        int data;
        Person lee; 
        data = 2024; // 기본자료형은 바로 값을 저장할 수 있다.
        lee = new Person(); // 참조자료형은 객체를 생성하고 사용할 수 있다.
        Person kim = new Person(); // 참조변수를 선언하면서 바로 생성할 수 있다.
//        lee.sename = "이재원";
//        lee.gender = "남자";
//        lee.age = 28;
        lee.setName("이재원");
        lee.setGender("남자");
        lee.setAge(28);

        lee.eat("비비빅");
        lee.walk("청계천");

        System.out.println();

        System.out.println("이름: " + lee.getName());
        System.out.println("성별: " + lee.getGender());
        System.out.println("나이: " + lee.getAge());
    }
        
}
