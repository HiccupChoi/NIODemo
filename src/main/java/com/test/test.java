package com.test;

import java.util.ArrayList;

/**
 * @Author: Hiccup
 * @Date: 2019/11/28 11:02 上午
 */
public class test {

    private static final int[] WAIT_TIME_LIST = {0, 10, 20, 40, 60, 80, 100, 120, 140, 160, 180, 360, 360, 720, 720, 1440, 1440, 2880, 2880, 2880};

    public static void main(String[] args) {
        array();
    }

    private static void test(){
        ArrayList arrayList = new ArrayList();
        test2(arrayList);
        System.out.println(arrayList);
    }

    private static Integer test2(ArrayList arrayList){
        arrayList.addAll(null);


        return 1;
    }

    private static void array(){
        System.out.println(WAIT_TIME_LIST.length);
        System.out.println(WAIT_TIME_LIST[20]);
    }

}
