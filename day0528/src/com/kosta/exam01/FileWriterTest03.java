package com.kosta.exam01;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest03 {
    public static void main(String[] args) {

        try {
//            FileWriter fw = new FileWriter("/Users/donggyun/data/hello.txt");
            FileWriter fw = new FileWriter("/Users/donggyun/daka/hello.txt"); // data => daka
            fw.write("hello java");
            fw.close();
            System.out.println("파일을 생성하였습니다.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("예외발생: " + e.getMessage());
        }
    }
}
/*
/Users/donggyun/intellij-workspace/kosta/day0528/src/com/kosta/exam01/FileWriterTest.java:7:25
java: unreported exception java.io.IOException; must be caught or declared to be thrown
* */
