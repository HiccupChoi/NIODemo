package com.jni;


import java.io.File;

public class helloJni{
    public native String displayHelloWorld();
    static{
        System.load(new File("src/main/resources/libJniTest.dylib").getAbsolutePath());//载入本地库
    }
    public static void main(String[] args){
        String xxx = new helloJni().displayHelloWorld();
        System.out.println(xxx);
    }
}