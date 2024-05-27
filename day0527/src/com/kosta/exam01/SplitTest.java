package com.kosta.exam01;

public class SplitTest {
    public static void main(String[] args) {
        String data = "홍길동, 임유나, 변시우, 조영흔, 유요한";
        String[] arr = data.split(", ");
        for (String str : arr) {
            System.out.println(str);
        }
    }
}
