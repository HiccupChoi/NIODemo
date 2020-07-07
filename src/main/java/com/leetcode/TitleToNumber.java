package com.leetcode;

/**
 * @Author: Hiccup
 * @Date: 2020/6/29 14:43
 */
public class TitleToNumber {

    public static void main(String[] args) {
        System.out.println(titleToNumber("A"));
    }

    private static int titleToNumber(String s) {
        int targe = 0;

        for(int i = s.length() - 1; i >= 0; i--){
            targe += (s.charAt(i) - 'A' + 1) * Math.pow(26 , s.length() - i - 1);
        }

        return targe;
    }

}
