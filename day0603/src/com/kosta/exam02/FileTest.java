package com.kosta.exam02;

import java.io.File;

// Users/donggyun/data/hello.txt 파일을 삭제하는 프로그램
public class FileTest {
    public static void main(String[] args) {
        File file = new File("/Users/donggyun/data/새 파일");
        System.out.println("3초 뒤에 파일이 삭제됩니다.");
        try {
            Thread.sleep(3000);
        } catch(InterruptedException e) {
            System.out.println("예외 발생:" + e.getMessage());
        }
        // 파일 삭제
        file.delete();

    }
}
