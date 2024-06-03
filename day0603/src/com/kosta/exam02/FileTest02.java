package com.kosta.exam02;

import java.io.File;

public class FileTest02 {
    public static void main(String[] args) {
        File file = new File("/Users/donggyun/data");
        String[] arr = file.list();
        for (String file_name : arr) {
            System.out.println(file_name);
        }
    }
}
