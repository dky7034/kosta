package com.kosta.exam01;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest05 {

    // 메서드 선언
    public static void pro(String fname) throws IOException {
            FileWriter fw = new FileWriter(fname);
            fw.write("hello java");
            fw.close();
            System.out.println("파일을 생성하였습니다.");
    }
    // 메인 메서드
    public static void main(String[] args) {
        try {
            pro("/Users/donggyun/data/hello.txt");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("예외 발생: " + e.getMessage());
            System.out.println("예외 발생: " + e);
        }
    }
}

//예외 발생: /Users/donggyun/daka/hello.txt (No such file or directory)