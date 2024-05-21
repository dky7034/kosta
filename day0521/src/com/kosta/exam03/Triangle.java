package com.kosta.exam03;

public class Triangle extends TwoDimShape  {
    // 필드
    private double width;
    private double length;

    // 생성자
    public Triangle() {}
    public Triangle(int x, int y, double width, double length) {
        super(x, y);
        this.width = width;
        this.length = length;
    }

    // 추상메서드 오버라이딩
    @Override
    public void calcArea() {
        area = (width * length) / 2;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "width=" + width +
                ", length=" + length +
                ", area=" + area +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
