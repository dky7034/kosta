package com.kosta.exam04;

public class SayHelloTest {
    public static void main(String[] args) {
        (new Thread(new SayHello())).start();
    }
}
