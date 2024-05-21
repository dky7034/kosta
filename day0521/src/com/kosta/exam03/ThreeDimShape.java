package com.kosta.exam03;

public abstract class ThreeDimShape extends Shape {
    // 필드(부피)
    protected double volume;

    // 추상메서드 (자식클래스에서 구현)
    public abstract void calcVolume();
    // 일반적인 메서드
    public void pro() {
        System.out.println("ThreeDimShape의 pro입니다.");
    }

    // getter
    public double getVolume() {
        return volume;
    }

    // 생성자
    public ThreeDimShape() {}
    public ThreeDimShape(int x, int y) {
        super(x, y);
    }

    // toString override
    @Override
    public String toString() {
        return "ThreeDimShape{" +
                "volume=" + volume +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
