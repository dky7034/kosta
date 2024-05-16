package com.kosta.exam01;

import java.util.Scanner;

class Student {
    String name;
    int kor;
    int eng;
    int math;
    int tot;
    double avg;
}

public class D07StudentClassTest {
    public static void main(String[] args) {
        Student data;
        data = new Student(); // 클래스 참조변수는 new에 의하여 객체를 생성하고 사용할 수 있습니다.
        Scanner sc = new Scanner(System.in);
        System.out.print("학생의 이름 => ");
        data.name = sc.next();
        System.out.print("학생의 국어점수 => ");
        data.kor = sc.nextInt();
        System.out.print("학생의 영어점수 => ");
        data.eng = sc.nextInt();
        System.out.print("학생의 수학점수 => ");
        data.math = sc.nextInt();

        data.tot = data.kor + data.eng + data.math;
        data.avg = data.tot / 3.0;
        System.out.println(data.name + ", " + data.kor + ", " + data.eng + ", " + 
                            data.math + ", " + data.tot + ", " + data.avg);
    }
}


