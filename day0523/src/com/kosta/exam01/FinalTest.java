package com.kosta.exam01;

class A {
    public void pro() {
        System.out.println("A클래스의 pro입니다.");
    }
    // final class
    // override 불가능
    public final void test() {
        System.out.println("테스트입니다.");
    }
}

class B extends A {
    @Override
    public void pro() {
        System.out.println("B클래스의 pro입니다.");
    }
}

public class FinalTest {
    public static void main(String[] args) {
        B ob = new B();
        ob.pro();
    }
}
