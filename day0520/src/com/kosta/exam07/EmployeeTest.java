package com.kosta.exam07;

import java.util.Scanner;

// 사용자 입력받아 월급제 사원, 시간제 사원 처리하는 프로그램으로 수정
public class EmployeeTest {
    public static void main(String[] args) {
        // 몇 명의 사원을 입력받을까?
        // 일단, 배열 선언
        Scanner sc = new Scanner(System.in);
        int menu;
        Employee[] data = new Employee[100];

        String no, name;
        int level, base, hours;
        int i = 0;

        while (true) {
            do {
                System.out.println("선택하세요 ==> 1. 월급제사원, 2. 시간제사원, 0. 종료");
                menu = sc.nextInt();
            } while (menu < 0 || menu > 2);

            if (menu == 0) {
                break;
            }

            System.out.print("사원 번호 ==> ");
            no = sc.next();
            System.out.print("사원 이름 ==> ");
            name = sc.next();

            switch (menu) {
                case 1:
                    System.out.print("호봉 입력 ==> ");
                    level = sc.nextInt();
                    data[i] = new SalariedEmployee(name, no, level);
                    break;
                case 2:
                    System.out.print("시간당 임금 ==> ");
                    base = sc.nextInt();
                    System.out.print("일 한 시간 ==> ");
                    hours = sc.nextInt();
                    data[i] = new HourlyEmployee(name, no, base, hours);
                    break;
            } // end switch
            i++;
        } // end while
        int n = i;
        for (i=0; i<n; i++) {
            data[i].computeSalary();
            System.out.println(data[i]);
        }
    } // end main method
} // end class
