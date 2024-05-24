package com.kosta.file;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// 어떤 사람의 이름, 주소, 전화를 입력받아 출력하는 프로그램
public class FileTest01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name, addr, phone;
        System.out.print("이름을 입력 ==> ");
        name = sc.next();
        System.out.print("주소를 입력 ==> ");
        addr = sc.next();
        System.out.print("전화번호 입력 ==> ");
        phone = sc.next();

        System.out.println("이름: " + name);
        System.out.println("주소: " + addr);
        System.out.println("전화: " + phone);

        try {
            FileWriter fileWriter = new FileWriter("/Users/donggyun/Downloads/data/info.txt", true);
            // 파일 생성시에 두 번째 매개변수(append mode)에 true를 주면
            // 그 파일이 없다면 새로 만들어주고,
            // 그 파일이 이미 있다면 내용을 추가해 줍니다.
            fileWriter.write("이름: " + name + "\n");
            fileWriter.write("주소: " + addr + "\n");
            fileWriter.write("전화: " + phone + "\n");
            // 파일 사용 끝(close();)
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
