package com.kosta.exam08;

public class ShapeTest {
    public static void main(String[] args) {
//        Rectangle r = new Rectangle(10, 10, 100, 100);
//        Circle c = new Circle(50);
        // 부모의 참조변수는 자식의 객체를 생성할 수 있습니다!
        // 부모의 참조변수는 자식의 객체를 참조할 수 있습니다!
        Shape rectangle = new Rectangle(10, 10, 100, 100);
        Shape circle = new Circle(50);

//        r.calcArea();
//        r.calcRound();
//
//        c.calcArea();
//        c.calcRound();

        rectangle.calcArea();
        rectangle.calcRound();

        circle.calcArea();
        circle.calcRound();
    }
}
