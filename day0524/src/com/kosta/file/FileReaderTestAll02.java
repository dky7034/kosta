package com.kosta.file;

import java.io.FileReader;

public class FileReaderTestAll02 {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("/Users/donggyun/Downloads/data/info.txt");
            int ch;

            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
