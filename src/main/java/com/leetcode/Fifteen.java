package com.leetcode;

/**
 * @Author: Hiccup
 * @Date: 2019/8/24 19:01
 * LeetCode - 38报数
 *
 */
public class Fifteen {

    public static void main(String[] args) {
        for (int i = 1; i < 30; i++) {
            System.out.println(countAndSay(i));
        }
    }

    private static String countAndSay(int n) {
        String str = "1";

        for (int i = 0; i < n - 1; i++) {
            int count = 0;
            char pre = str.charAt(0);
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < str.length(); j++) {
                if (pre == str.charAt(j)){
                    count++;
                } else {
                    stringBuilder.append(count).append(pre);
                    count = 1;
                    pre = str.charAt(j);
                }
            }
            str = stringBuilder.append(count).append(pre).toString();
        }
        return str;
    }
}
