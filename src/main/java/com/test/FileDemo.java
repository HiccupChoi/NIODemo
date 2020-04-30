package com.test;

import java.io.File;
import java.io.FilenameFilter;

public class FileDemo {
   public static void main(String[] args) {
      System.out.println("listRoots()获取本机所有盘符……………………………………………");
      File[] files = File.listRoots();
      for (File everyFile : files) {
         System.out.println(everyFile);
      }
      System.out.println("list()获取F盘下的所有文件………………………………………………");
      File f1 = new File("F:\\");// 将F盘封装成了一个文件类对象
      String[] fileNames = f1.list();
      for (String fn : fileNames) {
         System.out.println(fn);
      }
      System.out.println("list()获取F盘下的.txt文件之方法(一)…………………………………");
      File f2 = new File("F:\\");// 将F盘封装成了一个文件类对象
      String[] fNames = f2.list();
      for (String fn : fNames) {
         if (fn.endsWith(".txt")) {
            System.out.println(fn);
         }
      }
      System.out.println("list()获取F盘下的.txt文件之方法(二)……………………………………");
      File f3 = new File("F:\\");
      String[] FNames = f3.list(new FilenameFilter() {
         public boolean accept(File f3, String string) {//file接收的是盘号，string接收的是盘里的文件名称
            return string.endsWith(".txt");
         }
      });
      for(String fileName:FNames){
         System.out.println(fileName);
      }
   }
}

