package com.kosta.exam03;

import java.util.Scanner;

public class ShapeTest {
    public static void main(String[] args) {
        Shape[] data = new Shape[1000];
        Scanner sc = new Scanner(System.in);
        int menu;
        int n = 0;
        double width, lenght, height, radius; // 2차원, 3차원 도형에 필요한 변수
        int x, y; // 도형의 위치를 표현할 변수

        while (true) {

            do {
                System.out.println("1. 사각형, 2. 삼각형, 3.직육면체, 4. 원기둥, 0. 종료");
                System.out.print("도형의 종류를 선택하세요 ==> ");
                menu = sc.nextInt();
            } while (menu < 0 || menu > 4);

            if (menu == 0) {
                break;
            } // end if

            System.out.print("도형의 x위치 ==> ");
            x = sc.nextInt();
            System.out.print("도형의 y위치 ==> ");
            y = sc.nextInt();

            switch (menu) {
                case 1:
                    System.out.println("사각형의 가로 ==> ");
                    width = sc.nextDouble();
                    System.out.println("사각형의 세로 ==> ");
                    lenght = sc.nextDouble();
                    data[n] = new Rectangle(x, y, width, lenght);
                    break;
                case 2:
                    System.out.println("삼각형의 밑변 ==> ");
                    width = sc.nextDouble();
                    System.out.println("삼각형의 높이 ==> ");
                    lenght = sc.nextDouble();
                    data[n] = new Triangle(x, y, width, lenght);
                    break;
                case 3:
                    System.out.println("직육면체의 가로 ==> ");
                    width = sc.nextDouble();
                    System.out.println("직육면체의 세로 ==> ");
                    lenght = sc.nextDouble();
                    System.out.println("직육면체의 높이 ==> ");
                    height = sc.nextDouble();
                    data[n] = new Cuboid(x, y, lenght, height);
                    break;
                case 4:
                    System.out.println("원기둥의 반지름 ==> ");
                    radius = sc.nextDouble();
                    System.out.println("원기둥의 높이 ==> ");
                    height = sc.nextDouble();
                    data[n] = new Cylinder(x, y, radius, height);
                    break;
            }
            n++;

        } // end while
        for (int i=0; i<n; i++) {
            if (data[i] instanceof TwoDimShape) {
                // 최상위 부모클래스인 Shape에 없는 메서드를 호출하기 위한 다운캐스팅
                // Shape -> TwoDimShape
                ((TwoDimShape)data[i]).calcArea();
            } else if (data[i] instanceof ThreeDimShape) {
                ((ThreeDimShape)data[i]).calcVolume();
            }
            System.out.println(data[i]);
        }

    } // end main
} // end class
