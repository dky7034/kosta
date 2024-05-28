package com.kosta.exam01;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest01 {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("/Users/donggyun/data");
        fw.write("hello java");
        fw.close();
        System.out.println("파일을 생성하였습니다.");
    }
}
/*
/Users/donggyun/intellij-workspace/kosta/day0528/src/com/kosta/exam01/FileWriterTest.java:7:25
java: unreported exception java.io.IOException; must be caught or declared to be thrown
* */
