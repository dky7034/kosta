package com.kosta.file;

import java.io.FileReader;

public class FileReaderTestAll03 {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("/Users/donggyun/Downloads/data/info.txt");
            int ch;
            String data = "";
            while ((ch = fr.read()) != -1) {
                data += (char)ch;
            }
            System.out.println(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
