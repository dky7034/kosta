package com.kosta.exam08;

public class Shape {
    protected int x;
    protected int y;
    protected double area;
    protected double round;

    // 메서드
    public void calcArea() {}
    public void calcRound() {}

    // getter and setter
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getArea() {
        return area;
    }

    public double getRound() {
        return round;
    }

    // 생성자
    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }
    // 기본 생성자
    public Shape() {}
}
