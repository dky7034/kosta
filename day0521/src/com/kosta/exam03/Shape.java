package com.kosta.exam03;

public class Shape {
    // 도형의 위치 x, y
    protected int x;
    protected int y;

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

    // 생성자
    public Shape() {};
    public Shape(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // toString override
    @Override
    public String toString() {
        return "Shape{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
