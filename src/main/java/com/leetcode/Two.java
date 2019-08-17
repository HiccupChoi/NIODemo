package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author: Hiccup
 * @Date: 2019/8/17 15:05
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标
 */
public class Two {

    public static void main(String[] args) {
        int[] numS = {3,2,4};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(numS, target)));
    }


    private static int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> hashMapS = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (hashMapS.containsKey(num)){
                return new int[]{hashMapS.get(num), i};
            }
            hashMapS.put(target - nums[i], i);
        }
        return null;
    }
}
