package com.kosta.exam03;

public abstract class TwoDimShape extends Shape {
    // 필드(너비)
    protected double area;

    // 추상메서드 (자식클래스에서 구현)
    public abstract void calcArea();

    // getter
    public double getArea() {
        return area;
    }

    // 생성자
    public TwoDimShape() {};
    public TwoDimShape(int x, int y) {
        super(x, y);
    }

    // toString override
    @Override
    public String toString() {
        return "TwoDimShape{" +
                "area=" + area +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
