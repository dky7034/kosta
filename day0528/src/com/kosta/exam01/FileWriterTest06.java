package com.kosta.exam01;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest06 {

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
            pro("/Users/donggyun/dkta/hello.txt");
        } catch (IOException e) {
            // 예외가 발생하면 어디에서 문제가 발생하였는지 추적해 가면서 정보를 출력하는 메서드.
            e.printStackTrace();
        }
    }
}



