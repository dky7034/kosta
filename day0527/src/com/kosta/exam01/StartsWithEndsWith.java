package com.kosta.exam01;

public class StartsWithEndsWith {
    public static void main(String[] args) {
        String data = "hello java";
        boolean flag1 = data.startsWith("hello");
        boolean flag2 = data.endsWith("java");
        boolean flag3 = data.endsWith("oracle");

        System.out.println(flag1);
        System.out.println(flag2);
        System.out.println(flag3);
    }
}
