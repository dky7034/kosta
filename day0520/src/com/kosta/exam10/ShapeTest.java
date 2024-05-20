package com.kosta.exam10;

import com.kosta.exam08.Circle;
import com.kosta.exam08.Rectangle;
import com.kosta.exam08.Shape;

import java.util.Scanner;

public class ShapeTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Shape[] data = new Shape[1000];
        int menu, i = 0;
        double width, length, radius;
        
        while (true) {
            while (true) {
                System.out.println("도형의 종류를 선택 ==> [1. 사각형, 2. 원, 0. 종료]");
                menu = sc.nextInt();
                if (menu >= 0 && menu <= 2) {
                    break;
                }
            }
            if (menu == 0) {
                break;
            }
            switch (menu) {
                case 1:
                    System.out.print("사각형의 가로길이 ==> ");
                    width = sc.nextDouble();
                    System.out.print("사각형의 세로길이 ==> ");
                    length = sc.nextDouble();
                    data[i] = new Rectangle(width, length); break;
                case 2:
                    System.out.print("원의 반지름 ==> ");
                    radius = sc.nextDouble();
                    data[i] = new Circle(radius); break;
            }
            i++;
        }
        System.out.println("작업종료");

        for (int j=0; j<i; j++) {
            data[j].calcArea();
            data[j].calcRound();
        }

    }
}
