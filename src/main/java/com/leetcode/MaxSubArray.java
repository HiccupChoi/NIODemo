package com.leetcode;


import java.util.Arrays;

/**
 * @Author: Hiccup
 * @Date: 2020/6/22 18:01
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] xx = {-2,1,-3,4,-1,2,1,-5,4};
        int[] yy = java.util.Arrays.copyOf(xx, 1);
        maxSubArrayTest(xx);
    }

    private static int maxSubArrayTest(int[] nums) {
        System.out.println(Arrays.toString(nums));
        int maxValue = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] > 0) nums[i] += nums[i-1];
            if(nums[i] > maxValue) maxValue = nums[i];
        }
        System.out.println(Arrays.toString(nums));
        return maxValue;
    }
}
