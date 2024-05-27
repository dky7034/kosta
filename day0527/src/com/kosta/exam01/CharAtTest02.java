package com.kosta.exam01;

public class CharAtTest02 {
    public static void main(String[] args) {
        String data = "hello java";
        int n = 0;
        System.out.println(data.length());
        for (int i = 0; i < data.length(); i++) {
            char ch = data.charAt(i);
            System.out.println(ch);
            if (ch == 'a') {
                n++;
            }
        }
        System.out.println("소문자 a의 수는: " + n);
    }
}
