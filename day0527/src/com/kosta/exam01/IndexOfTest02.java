package com.kosta.exam01;

public class IndexOfTest02 {
    public static void main(String[] args) {
        String data = "hello java hello oracle";
        int n = data.indexOf("hello");
        System.out.println(n);
        int n2 = data.indexOf("java", 0);
        System.out.println(n2);
    }
}
