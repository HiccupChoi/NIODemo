package com.file;

import org.junit.Test;
import sun.tools.tree.NewArrayExpression;

import java.io.File;
import java.io.IOException;

/**
 * @Author: Hiccup
 * @Date: 2019/11/28 4:53 下午
 */
public class FileMethod {


    @Test
    public void baseMethod(){
        File file = new File("src/main/resources/test.txt");
        System.out.println(file.getName());
        System.out.println(file.getParent());
        System.out.println(file.getPath());
        System.out.println(file.getAbsolutePath());
    }

    /**
     * deleteOnExit 在程序退出时删除
     * delete 直接删除
     */
    @Test
    public void delete(){
        File file = new File("src/test/java/com.FileTest");
        if (file.exists()){
            file.deleteOnExit();
        } else {
            boolean success = file.mkdirs();
            if (success){
                System.out.println("创建成功");
            }
        }
    }

    @Test
    public void createFile() throws IOException {
        File file = new File("src/test/java/com.FileTest/com.FileTest.java");
        boolean success = file.createNewFile();
        if (success){
            System.out.println("创建成功");
        } else {
            boolean deleteSuccess = file.delete();
            if (deleteSuccess){
                System.out.println("删除成功");
            }
        }
    }

    public static void main(String[] args) {
        listFile("src/main");
    }


    private static void listFile(String files){
        File file = new File(files);
        String[] filePaths = file.list();
        assert filePaths != null;
        for (String filePath : filePaths) {
            String fileString = files + File.separatorChar + filePath;
            if (new File(fileString).isDirectory()){
                System.out.println(fileString);
                listFile(fileString);
            } else {
                System.out.println("    " + filePath);
            }
        }
    }

    @Test
    public void rename(){
        File file = new File("src/main/resources/renameTest.txt");
        boolean success = file.renameTo(new File("src/main/resources/test.txt"));
        System.out.println("改名" + (success ? "成功" : "失败"));
    }

    @Test
    public void readOnly(){
        File file = new File("src/main/java/com/file/test.txt");
        file.setReadOnly();
    }
}
