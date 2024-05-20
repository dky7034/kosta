package com.kosta.exam08;

public class Rectangle extends Shape {
    // 가로, 높이 변수 선언
    private int width;
    private int height;

    // 생성자
    public Rectangle(int x, int y, int width, int height) {
//        this.x = x;
//        this.y = y;
        super(x, y);
        this.width = width;
        this.height = height;
    }
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
    // 기본생성자
    public Rectangle(double width, double length) {}
    
    // 메서드 오버라이드
    @Override
    public void calcArea() {
        area = width * height;
        System.out.println("사각형의 면적: " + area);
    }

    @Override
    public void calcRound() {
        round = 2 * (width + height);
        System.out.println("사각형의 둘레: " + round);
    }
    
    // toString 오버라이드

    @Override
    public String toString() {
        return "사각형의 면적: " + area + ", " + "사각형의 둘레: " + round;
    }
}
