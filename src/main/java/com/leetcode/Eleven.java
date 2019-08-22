package com.leetcode;

/**
 * @Author: Hiccup
 * @Date: 2019/8/22 2:08 PM
 * 原地去除数组指定元素
 */
public class Eleven {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1,2,4,3,8,4};
        int val = 3;
        int length = removeElement(nums, val);
        for (int i = 0; i < length; i++) {
            System.out.println(nums[i]);
        }
    }

    private static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }

        return ++i;
    }

}
