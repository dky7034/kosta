package com.kosta.exam03;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        Random rand = new Random();

        int data = rand.nextInt();
        System.out.println(data); // int의 범위 내에서 무작위 추출

        int data2 = rand.nextInt(10); // 0 ~ 10-1 사이에서 무작위 추출
        System.out.println(data2);

        int data3 = rand.nextInt(10) + 1; // 1 ~ 10 사이에서 무작위 추출
        System.out.println(data3);

    }
}
