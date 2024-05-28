package com.kosta.exam02;

import java.util.ArrayList;
import java.util.Scanner;

// 배열 안에 찾는 숫자가 없을 경우의 예외를 만들어 줍시다.
class NotFoundException extends Exception {
    public NotFoundException(String msg) {super(msg);}
}

class SearchArray {
    public SearchArray(int[] arr, int value) throws NotFoundException {
        int i;
        // ArryList<Integer>를 사용하여 값을 찾을 때마다 인덱스를 저장함.
        ArrayList<Integer> list = new ArrayList<>();
        for (i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                list.add(i);
            }
        }
        if (list.size() == 0) {
            throw new NotFoundException("찾고자 하는 데이터 " + value + "은/는 배열에 없습니다.");
        } else {
            System.out.println("찾고자 하는 데이터 " + value + "은/는 인덱스" + list + "에 있습니다.");
        }
    }
}

public class SearchArrayTest {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            int[] arr = {10, 20, 30, 40, 50};
            System.out.print("찾을 숫자를 입력해 주세요 ==> ");
            int value = sc.nextInt();
            SearchArray searchArray = new SearchArray(arr, value);

            // 배열 안에 찾고자 하는 값이 없을 경우(예외)
            boolean found = false;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == value) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                throw new NotFoundException(value + "은/는" + " 배열 안에 없는 숫자입니다.");
            }

        } catch (NotFoundException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}
