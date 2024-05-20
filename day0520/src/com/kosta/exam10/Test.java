package com.kosta.exam10;

public class Test {
    public static void main(String[] args) {
        int[] array = {2, 5, 1, 7, 10, 9};
        for (int i=0; i<array.length; i++) {
            int temp = 0;
            for (int j=1; j<array.length; j++) {
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        for (int elem : array) {
            System.out.println(elem);
        }
    }

}
