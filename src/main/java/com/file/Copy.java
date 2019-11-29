package com.file;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copy {
    public static void main(String[] args) {
        int n;
        try {
            FileInputStream fis = new FileInputStream("src/main/java/com/file/test.txt");
            FileOutputStream fos = new FileOutputStream("src/main/java/com/file/test2.txt");

            while ((n = fis.read()) != -1) {
                fos.write(n);
            }

            fis.close();
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
