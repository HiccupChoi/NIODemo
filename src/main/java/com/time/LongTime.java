package com.time;


import java.util.ArrayList;

/**
 * @Author: Hiccup
 * @Date: 2020/3/27 11:54
 */
public class LongTime {

    public static void main(String[] args) {
        foreachtest();
    }

    // Hideously slow! Can you spot the object creation?
    private static long sum() {
        long start = System.currentTimeMillis();
        long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++)
            sum += i;
        System.out.println(System.currentTimeMillis() - start);
        return sum;
    }

    private static void foreachtest(){
        ArrayList arrayList = new ArrayList();
        for (Object object : arrayList) {
            System.out.println(object);
        }
    }

}
