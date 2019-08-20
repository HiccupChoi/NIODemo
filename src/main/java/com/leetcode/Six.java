package com.leetcode;

import java.util.HashMap;

/**
 * @Author: Hiccup
 * @Date: 2019/8/20 5:28 PM
 * 罗马数组转为整数
 */
public class Six {

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    private static int romanToInt(String s) {
        s = s + "#";
        byte[] bytes = s.getBytes();
        int num = 0;
        HashMap<Byte, Integer> hashMap = new HashMap();
        hashMap.put((byte) 'I', 1);
        hashMap.put((byte) 'V', 5);
        hashMap.put((byte) 'X', 10);
        hashMap.put((byte) 'L', 50);
        hashMap.put((byte) 'C', 100);
        hashMap.put((byte) 'D', 500);
        hashMap.put((byte) 'M', 1000);
        hashMap.put((byte) '#', 0);
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] == 35) {
                break;
            }
            int x = hashMap.get(bytes[i]);
            num += hashMap.get(bytes[i + 1]) > x ? -x : x;
        }
        return num;
    }
}
