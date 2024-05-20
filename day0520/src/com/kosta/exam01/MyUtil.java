package com.kosta.exam01;

public class MyUtil {
    // 두 개의 정수를 매개변수로 전달받아 그 중에 큰 수를 찾아서 반환하는 메서드
    public int getMax(int a, int b) {
        int max = a;
        if (max < b) {
            max = b;
        }
        return max;
    }
    // 두 개의 실수를 매개변수로 전달받아 그 중에 큰 수를 찾아서 반환하는 메서드
    public double getMax(double a, double b) {
        if (a < b) {
            a = b;
        }
        return a;
    }
    // 실수형 배열을 매개변수로 전달받아 그 중에 큰 수를 찾아서 반환하는 메서드
    public double getMax(double[] arr) {
        double max = arr[0];
        for (int i=1; i<arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }
    // test
    public static void main(String[] args) {
        MyUtil myUtil = new MyUtil();
        int result = myUtil.getMax(1, 2);
        System.out.println("max: " + result);
        double result2 = myUtil.getMax(2.3, 1.2);
        System.out.println("max2: " + result2);
    }

}
