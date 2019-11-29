package com.test;

import java.io.InputStream;

public class TestCMD {

	    public static void main(String[] args) {
	      //文件路径带空格：
	        String path1 = "C:\\\"Program Files\"\\Git\\git-cmd.exe";
	        //文件名带空格：
	        String path2 = "C:\\Windows\\test\\\"test Capture Tool\".exe";
	        Runtime run = Runtime.getRuntime();
	        try {
	            Process process = run.exec("cmd.exe /c start " + path1);
	            InputStream in = process.getInputStream();
	            while (in.read() != -1) {
	                System.out.println(in.read());
	            }
	            in.close();
	            process.waitFor();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    }
}

