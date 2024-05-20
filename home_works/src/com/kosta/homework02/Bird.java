package com.kosta.homework02;
// 새의 속성과 동작을 분석하여 클래스를 만들고 테스트
public class Bird {

    // 속성(멤버변수)
    private String name;
    private int age;
    private String color;
    private boolean canFly;
    // 동작(메서드)
    public void fly() {
        if (canFly) {
            System.out.println("cannot fly...");
        } else {
            System.out.println("can fly...");
        }
    }


}
