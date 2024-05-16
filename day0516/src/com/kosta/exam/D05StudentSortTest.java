package com.kosta.exam;

import java.util.Scanner;

// 5명 학생의 이름, 국어, 영어, 수학을 입력받아
// 총점, 평균을 구하고
// 

public class D05StudentSortTest {

    // 국어, 영어, 수학을 입력받기 위한 메서드
    // public static void inputScore(int kor, int eng, int math) {
    //     int
    //     for (int i=0; i<5; i++) {
            
    //     }
    // }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] name = new String[3];
        int[] kor = new int[3];
        int[] eng = new int[3];
        int[] math = new int[3];
        int[] tot = new int[3];
        double[] avg = new double[3];
        
        for (int i=0; i<name.length; i++) {
            System.out.printf("%d번째 학생의 이름 => ", i+1);
            name[i] = sc.next();
            // 국어, 영어, 수학을 입력받고 총점과 평균을 계산하여 배열에 담아봅시다.
            System.out.printf("%d번째 학생의 국어점수 => ", i+1);
            kor[i] = sc.nextInt();
            System.out.printf("%d번째 학생의 영어점수 => ", i+1);
            eng[i] = sc.nextInt();
            System.out.printf("%d번째 학생의 수학점수 => ", i+1);
            math[i] = sc.nextInt();
            tot[i] = kor[i] + eng[i] + math[i];
            avg[i] = tot[i] / 3.0;
        }

        System.out.println("*** 성적 처리 결과 ***");
        System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
        for (int i=0; i<name.length; i++) {
            System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\n", 
                                    name[i], kor[i], eng[i], math[i], tot[i], avg[i]);
        }

        // 성적이 높은 순으로 정렬하기
        for(int i=0; i<tot.length; i++) {
            for (int j=i+1; j<tot.length; j++) {
                if (tot[j] > tot[i]) {
                    String temp_name = "";
                    temp_name = name[i];
                    name[i] = name[j];
                    name[j] = temp_name;

                    int temp_tot = 0;
                    temp_tot = tot[i];
                    tot[i] = tot[j];
                    tot[j] = temp_tot;

                    double temp_avg = 0;
                    temp_avg = avg[i];
                    avg[i] = avg[j];
                    avg[j] = temp_avg;

                }
            }
        }

        System.out.println();

        System.out.println("*** 정렬 후 성적 처리 결과 ***");
        System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
        for (int i=0; i<name.length; i++) {
            System.out.printf("%s\t%d\t%d\t%d\t%d\t%.2f\n", 
                                    name[i], kor[i], eng[i], math[i], tot[i], avg[i]);
        }

    }
}
