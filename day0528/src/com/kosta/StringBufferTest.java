package com.kosta;

public class StringBufferTest {
    public static void main(String[] args) {
        StringBuffer data = new StringBuffer("hello");
        System.out.println(data);
        data.append(" java");
        System.out.println(data);
    }
}
