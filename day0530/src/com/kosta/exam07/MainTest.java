package com.kosta.exam07;

// 생산자 스레드와 소비자 스레드를 생성하여 가동
public class MainTest {
    public static void main(String[] args) {
        Product product = new Product();
        Producer producer = new Producer(product);
        Consumer consumer = new Consumer(product);

        producer.start();
        consumer.start();
    }
}
