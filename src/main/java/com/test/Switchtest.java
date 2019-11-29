package com.test;

/**
 * @Author: Hiccup
 * @Date: 2019/11/12 5:39 下午
 */
public class Switchtest {

    public static void main(String[] args) {
        switchTest(2);
    }

    private static void switchTest(int x){
        switch (x){
            default:
                System.out.println("=======================");
                break;
            case 1:
                System.out.println("-----------------------");
                break;
            case 2:
                System.out.println("+++++++++++++++++++++++");
                break;
        }
    }

}
