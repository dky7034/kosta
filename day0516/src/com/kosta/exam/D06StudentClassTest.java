package com.kosta.exam;

class Student {
    String name;
    int kor;
    int eng;
    int math;
    int tot;
    double avg;
}

public class D06StudentClassTest {
    public static void main(String[] args) {
        int year;
        year = 2024;
        Student data;
        data = new Student();
        data.name = "홍길동";
        data.kor = 100;
        data.eng = 80;
        data.math = 90;
        data.tot = data.kor + data.eng + data.math;
        data.avg = data.tot / 3.0;
        System.out.println(year);
        System.out.println(data.name + ", " + data.kor + ", " + data.eng + ", " + 
                            data.math + ", " + data.tot + ", " + data.avg);
    }
}


