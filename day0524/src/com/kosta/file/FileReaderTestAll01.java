package com.kosta.file;

import java.io.FileReader;

public class FileReaderTestAll01 {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("/Users/donggyun/Downloads/data/info.txt");
            int ch;

            while (true) {
                ch = fr.read();
                System.out.print((char) ch);
                // 파일의 끝에 도달하면 종료
                if (ch == -1) {
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
