package com.kosta.exam03;

public class Cuboid extends ThreeDimShape {
    // 필드 선언(가로, 세로, 높이)
    private double width;
    private double length;
    private double height;

    // 생성자
    public Cuboid(int x, int y, double lenght, double height) {super();}

    @Override
    public void calcVolume() {
        volume = width * length * height;
    }

    // getter and setter
    public double getWidth() {return width;}
    public double getLength() {return length;}
    public double getHeight() {return height;}
    public void setWidth(int width) {this.width = width;}
    public void setLength(int length) {this.length = length;}
    public void setHeight(int height) {this.height = height;}

    public Cuboid(double width, double length, double height) {
        this.width = width;
        this.length = length;
        this.height = height;
    }
}
