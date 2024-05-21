package com.kosta.exam03;

public class Cylinder extends ThreeDimShape {
    // 필드 (PI, 반지름, 높이)
    public static final double PI = 3.14;
    private double radius;
    private double height;

    // 생성자
    public Cylinder() {}
    public Cylinder(int x, int y, double radius, double height) {
        super();
        this.radius = radius;
        this.height = height;
    }

    // 추상메서드 오버라이딩
    @Override
    public void calcVolume() {
        volume = PI * radius * radius * height;
    }

}
