package com.leetcode;

/**
 * @Author: Hiccup
 * @Date: 2019/8/21 5:38 PM
 * 删除排序数组中的重复项
 */
public class Ten {

    public static void main(String[] args) {
        print();
    }

    private static void print(){
        int[] nums = new int[]{1,2,2,3,5,7,9};
        int length = removeDuplicates(nums);
        for (int i = 0; i < length; i++) {
            System.out.println(nums[i]);
        }
    }

    /**
     * 双指针法：快慢指针
     * @param nums 测试数组
     * @return 最长不重复数组
     */
    private static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }
        return ++i;
    }

}
