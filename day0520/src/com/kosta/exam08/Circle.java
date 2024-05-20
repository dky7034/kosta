package com.kosta.exam08;

public class Circle extends Shape {
    private static final double pi = 3.14;
    private int radius;

    // 생성자
    public Circle(double radius) {}
    public Circle(int radius) {
        this.radius = radius;
    }

    // getter and setter
    public double getPi() {
        return pi;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
    
    // 메서드 오버라이드
    @Override
    public void calcArea() {
        area = pi * radius * radius;
        System.out.println("원의 넓이: " + area);
    }

    @Override
    public void calcRound() {
        round = 2 * pi * radius;
        System.out.printf("원의 지름: %.2f\n", round);
    }

    // toString 오버라이드
    @Override
    public String toString() {
        return "원의 넓이: " + area + ", " + "원의 지름: " + round;
    }
}