package com.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: Hiccup
 * @Date: 2019/11/27 3:42 下午
 */
public class FilePathTest {

    public static void main(String[] args) throws IOException {
        File test = new File("src/main/resources/test.txt");
        File newFile = new File("src/main/resources/test2.txt");
        FileOutputStream fout = new FileOutputStream(newFile);

        InputStream inputStreamFile = new FileInputStream(test);
        InputStream inputStream = FilePathTest.class.getResourceAsStream("/test.txt");
        byte[] bytes = new byte[100];
        int length = readFully(inputStreamFile, bytes);
        byte[] bytes1 = new byte[length];
        System.arraycopy(bytes, 0, bytes1, 0, length);
        try {
            fout.write(bytes1, 0, length);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fout.close();
        }
        System.out.println(new String(bytes1));
    }


    private static int readFully(InputStream in, byte[] b) {
        int size = b.length;
        int offset = 0;
        int len;
        for (; size > 0; ) {
            try {
                len = in.read(b, offset, size);
                if (len == -1) {
                    break;
                }
                offset += len;
                size -= len;
            } catch (Exception ex) {
                return 0;
            }
        }
        return offset;
    }

}
