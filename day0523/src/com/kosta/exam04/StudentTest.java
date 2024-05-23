package com.kosta.exam04;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentTest {
    private static Scanner sc = new Scanner(System.in);
    public static void menu() {
        System.out.println("1. 추가, 2. 검색, 3. 삭제, 0. 종료");
        System.out.println("메뉴를 선택하세요 ==> ");
    }
    // 메서드
    private static void insertStudent (ArrayList<Student> students) {
        String name, address, phone;
        System.out.println("*** 학생 정보 추가 ***");
        System.out.print("이름을 입력하세요: ");
        name = sc.next();
        System.out.print("주소를 입력하세요: ");
        address = sc.next();
        System.out.print("전화번호를 입력하세요: ");
        phone = sc.next();
        // 입력값을 토대로 Student 객체 생성:
        Student s = new Student(name, address, phone);
        students.add(s);
        System.out.println("학생의 정보를 추가하였습니다.");
        System.out.println("----------------------");
    }
    // 메서드
    private static void searchStudent (ArrayList<Student> students) {
        String name, phone;
        System.out.println("*** 학생 정보 검색 ***");
//        System.out.print("검색할 학생의 이름을 입력하세요 ==> ");
//        name = sc.next();
        System.out.print("검색할 학생의 전화번호를 입력하세요 ==> ");
        phone = sc.next();
        boolean flag = false;
        for (Student s : students) {
            if (s.getPhone().equals(phone)) {
                flag = true;
                System.out.println(s);
            }
        }
        if (flag == false) {
            System.out.println("찾고자 하는 학생의 정보는 없습니다.");
        }
    }

    // 메서드
    private static void deleteStudent (ArrayList<Student> students) {
        String name, phone;
        System.out.println("*** 학생 정보 검색 ***");
//        System.out.print("삭제할 학생의 이름을 입력하세요 ==> ");
//        name = sc.next();
        System.out.print("삭제할 학생의 전화번호를 입력하세요 ==> ");
        phone = sc.next();

        // for 반복문 사용
        int i;
        int cnt = students.size();
        for (i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            if (s.getPhone().equals(phone)) {
                students.remove(i);
                System.out.println("해당 학생의 정보를 삭제했습니다.");
                break;
            } // end if
        } // end for
        if (i == students.size()) {
            System.out.println("삭제하려는 학생의 정보가 없습니다.");
        }

//        // for-each 문 사용
//        int listSize = students.size();
//
//        for (Student s : students) {
//            if (s.getPhone().equals(phone)) {
//                System.out.println(s);
//                students.remove(s);
//                System.out.println("해당 학생의 정보를 삭제했습니다.");
//                break;
//            } // end if
//            if (listSize == students.size()) {
//                System.out.println("삭제하려는 학생의 정보가 없습니다.");
//            }
//        } // end for
    }


    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<Student>();
        int sel;
        String name, address, phone;

        while (true) {
            menu();
            sel = sc.nextInt();
            switch (sel) {
                case 0:
                    break;
            } // end switch

            switch (sel) {
                case 1:
                    insertStudent(students);
                    break;
                case 2:
                    searchStudent(students);
                    break;
                case 3:
                    deleteStudent(students);
                    break;
            } // end switch

        } // end while
    } // end main

} // end class
