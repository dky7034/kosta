package com.kosta.exam01;

public class ValueOfTest {
    public static void main(String[] args) {
        int year = 2024;
        String data = String.valueOf(year);

        double height = 56.7;
        String data_height = String.valueOf(height);

        boolean flag = false;
        String data_flag = String.valueOf(flag);

        char[] arr = {'h', 'e', 'l', 'l', 'o'};
        String data_arr = String.valueOf(arr);

        System.out.println(data);
        System.out.println(data_height);
        System.out.println(data_flag);
        System.out.println(data_arr);
    }
}
