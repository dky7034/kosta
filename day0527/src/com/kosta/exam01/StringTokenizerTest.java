package com.kosta.exam01;

import java.util.StringTokenizer;

public class StringTokenizerTest {
    public static void main(String[] args) {
        String data = "홍석영 임유나 변시우 조영흔 유요한";
        StringTokenizer st = new StringTokenizer(data);
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }
}
