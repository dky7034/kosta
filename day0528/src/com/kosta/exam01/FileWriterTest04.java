package com.kosta.exam01;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest04 {

    // 메서드 선언
    public static void pro(String fname) {
        try {
            FileWriter fw = new FileWriter(fname);
            fw.write("hello java");
            fw.close();
            System.out.println("파일을 생성하였습니다.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("예외발생: " + e);
        }
    }
    // 메인 메서드
    public static void main(String[] args) {
        pro("/Users/donggyun/daka/hello.txt");
    }
}
