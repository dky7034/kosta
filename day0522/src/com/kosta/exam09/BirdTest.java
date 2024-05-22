package com.kosta.exam09;

abstract class Bird {
    public abstract void sound();
}

class Dove extends Bird {
    @Override
    public void sound() {
        System.out.println("coo coo");
    }
}

public class BirdTest {
    public static void main(String[] args) {
//        Bird bird = new Bird();
        // 추상클래스는 바디가 구체화되지 않는 메서드가 있으므로 객체 생성을 할 수 없습니다...
        Bird b = new Dove();
        // 상속관계에서 자식클래스는 부모클래스에 포함관계에 있으므로
        // 부모클래스의 참조변수는 자식클래스의 객체를 참조할 수 있습니다...
    }
}
