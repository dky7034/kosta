package com.kosta.exam03;

public class Rectangle extends TwoDimShape {
    private int width;
    private int length;

    // 생성자
    public Rectangle(int x, int y, double width, double lenght) {
        super();
    }
    public Rectangle(int x, int y, int width, int length) {
        super(x, y);
        this.width = width;
        this.length = length;
    }

    @Override
    public void calcArea() {
        area = width * length;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", length=" + length +
                ", area=" + area +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
