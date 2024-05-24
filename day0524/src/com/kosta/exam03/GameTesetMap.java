package com.kosta.exam03;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

// 컴퓨터와 사용자가 가위 바위 보 하는 게임을 만들어 봅시다.
public class GameTesetMap {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(0, "가위");
        map.put(1, "바위");
        map.put(2, "보");

        Random rand = new Random();

        int computer = rand.nextInt(3);
        Scanner sc = new Scanner(System.in);
        System.out.println("*** 가위, 바위, 보 게임 ***");
        System.out.print("가위: 0, 바위: 1, 보: 2 선택하세요 ==> ");
        int user = sc.nextInt();
        System.out.printf("사용자는 %s를 냈습니다!\n", map.get(user));
        System.out.printf("컴퓨터는 %s를 냈습니다!\n", map.get(computer));

        if (user == computer) {
            System.out.println("비겼습니다!");
        }

    }
}
