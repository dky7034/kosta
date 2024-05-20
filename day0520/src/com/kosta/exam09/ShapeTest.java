package com.kosta.exam09;

import com.kosta.exam08.Circle;
import com.kosta.exam08.Rectangle;
import com.kosta.exam08.Shape;

public class ShapeTest {
    public static void main(String[] args) {
//        Circle[] circle = new Circle[100]; // Circle 타입만 저장 가능
//        Rectangle[] rectangle = new Rectangle[100]; // Rectangle 타입만 저장 가능
        Shape[] shape = new Shape[100]; // 자식클래스인 Circle, Rectangle 타입 모두 저장 가능

        Circle c1 = new Circle(5);
        Circle c2 = new Circle(10);
        Circle c3 = new Circle(20);

        Rectangle r1 = new Rectangle(3, 5);
        Rectangle r2 = new Rectangle(5, 6);
        Rectangle r3 = new Rectangle(10, 10);

        shape[0] = c1;
        shape[1] = r1;
        shape[2] = c2;
        shape[3] = c3;
        shape[4] = r2;
        shape[5] = r3;

        for (Shape elem : shape) {
            System.out.println(elem);
        }
    }
}
