package com.leetcode;

/**
 * @Author: Hiccup
 * @Date: 2020/6/29 10:36
 */
public class SingleNum {

    public static void main(String[] args) {
        System.out.println(singleNumberCalc(new int[]{1,3,1}));
    }

    private static int singleNumberCalc(int[] nums) {
        int temp = 0;
        for (int num : nums) {
            temp ^= num;
        }
        return temp;
    }

}
