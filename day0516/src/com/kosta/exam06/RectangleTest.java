package com.kosta.exam06;

class Rectangle {
    private double width;
    private double length;

    // getter & setter 메서드
    public double getWidth() {
        return width;
    }
    public double getLength() {
        return length;
    }
    public void setWidth(double wid) {
        width = wid;
    }
    public void setLength(double len) {
        length = len;
    }

    // 사각형의 넓이를 계산하는 메서드
    public double calcArea() {
        double area = width * length;
        return area;
    }
}

public class RectangleTest {

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle();
        r1.setWidth(200);
        r1.setLength(300);

        System.out.println("가로: " + r1.getWidth());
        System.out.println("세로: " + r1.getLength());
        System.out.println("면적: " + r1.calcArea());

        System.out.println(r1.getClass());

    }

}
