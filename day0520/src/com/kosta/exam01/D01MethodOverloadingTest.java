package com.kosta.exam01;

// MyUtil의 3개의 getMax를 각각 호출하는 실험을 해보세요.
public class D01MethodOverloadingTest {

    public static void main(String[] args) {
        MyUtil myUtil = new MyUtil();
        // 1. int
//        int resultInt = myUtil.getMax(10, 5);
        // 2. double
        double resultDouble = myUtil.getMax(1.5, 2.8);
        // 3. array
        double[] array = {1.2, 3.6, 0.9, 2.7, 1.1};
        double resultArray = myUtil.getMax(array);
        // 출력
//        System.out.println("resultInt: " + resultInt);
        System.out.println("resultDouble: " + resultDouble);
        System.out.println("resultArray: " + resultArray);

        // int 타입 배열을 getMax();에게 전달하면 어떻게 될까요?
        // 예상: double[]에서 max를 찾는 메서드가 동작할 것?
        // 결과: 배열에는 해당 X (에러 발생함)
        // 4. int[] array
        double[] arrayInt = {5, 7, 10, 1, 2};
        double resultArrayInt = myUtil.getMax(arrayInt);
    }

}
