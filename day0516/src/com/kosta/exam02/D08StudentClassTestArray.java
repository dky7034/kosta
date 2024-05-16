package com.kosta.exam02;

import java.util.Scanner;

class Student {
    String name;
    int kor;
    int eng;
    int math;
    int tot;
    double avg;
}

public class D08StudentClassTestArray {
    public static void main(String[] args) {
        Student data[];
        data = new Student[5]; // 객체 생성 X (참조변수를 5개 만든 것!)
        Scanner sc = new Scanner(System.in);
        for (int i=0; i<data.length; i++) {
            data[i] = new Student(); // 객체 생성 O (여기서 객체가 생성됨!)
            System.out.print("학생의 이름 => ");
            data[i].name = sc.next();
            System.out.print("학생의 국어점수 => ");
            data[i].kor = sc.nextInt();
            System.out.print("학생의 영어점수 => ");
            data[i].eng = sc.nextInt();
            System.out.print("학생의 수학점수 => ");
            data[i].math = sc.nextInt();
        
            data[i].tot = data[i].kor + data[i].eng + data[i].math;
            data[i].avg = data[i].tot / 3.0;
        }

        System.out.println("*** 성적 처리 결과 ***");
        System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
        System.out.println("----------------------------------------");
        for (int i=0; i<data.length; i++) {
            System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\n",
                                    data[i].name, data[i].kor, data[i].eng,
                                    data[i].math, data[i].tot, data[i].avg);
        }
        

    }
}


