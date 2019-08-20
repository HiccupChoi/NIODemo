package com.leetcode;

/**
 * @Author: Hiccup
 * @Date: 2019/8/20 5:06 PM
 * 判断一个数字是否是回文数
 * 进阶：不将数字转为字符串
 */
public class Five {

    public static void main(String[] args) {
        System.out.println(isPalindrome(10));
    }

    private static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }
        int y = 0;
        int z;
        while (x > y){
            z = x % 10;
            x /= 10;
            y = y * 10 + z;
        }

        return x == y || x == y / 10;
    }
}
