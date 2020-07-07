package com.leetcode;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Hiccup
 * @Date: 2020/6/29 14:57
 */
public class Solution {

    public static void main(String[] args) {
//        System.out.println(trailingZeroes(1808548329));
//        rotate(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27}, 38);
//        System.out.println(hammingWeight(Integer.parseInt("11111111111111111111111111111101", 2)));
//        System.out.println(rob(new int[]{1,3,1,2}));
//        for (int i = 0; i < 10000; i++) {
//            seen = new HashSet<>();
//            if (isHappy(i)){
//                System.out.println(i);
//            }
//        }
//        System.out.println(countPrimes(13));
        moveZeroes(new int[]{0,1,0,3,12});
    }

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     */
    private static void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;

        while(i < nums.length){
            if(nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            }
            i++;
        }

        while(j < nums.length){
            nums[j] = 0;
            j++;
        }

        System.out.println(Arrays.toString(nums));
    }

    /**
     * 小于n的质数有几个
     */
    private static int countPrimes(int n) {
        int count = n - 2;

        for(int i = 2; i < n; i++){
            for(int j = 2; j * j <= i; j++){
                if(i % j == 0) {count--; break;}
            }
        }

        return count;
    }

    private static Set<Integer> seen = new HashSet<>();

    /**
     * 欢乐数 99 -》 9+9=19 -》 1+9=10 -》 1+0=0
     */
    private static boolean isHappy(int n) {
        int ans = 0;

        while(n >= 10){
            int i = n % 10;
            n /= 10;
            ans += i * i;
        }

        ans += n * n;
        if(ans == 1) return true;
        if (seen.contains(ans)) return false;
        seen.add(ans);
        return isHappy(ans);
    }



    public static int rob(int[] nums) {
        int sumOdd = 0;
        int sumEven = 0;

        for (int i = 0; i < nums.length; i++)
        {
            if (i % 2 == 0)
            {
                sumEven += nums[i];
                sumEven = Math.max(sumOdd, sumEven);
            }
            else
            {
                sumOdd += nums[i];
                sumOdd = Math.max(sumOdd, sumEven);
            }
        }
        return Math.max(sumOdd, sumEven);
    }

    private static int hammingWeight(int n) {
        int count = 0;

        if(n < 0) count++;
        n = Math.abs(n);
        while(n > 0){
            if(n % 2 != 0 || (n == 2)) count++;
            if(n > 2) {
                n /= 2;
            } else {
                n = 0;
            }
        }

        return count;
    }

    /**
     * 给定一个整数 n，返回 n! 结果尾数中零的数量。
     */
    private static int trailingZeroes(int n) {

        int zeroCount = 0;
        // We need to use long because currentMultiple can potentially become
        // larger than an int.
        long currentMultiple = 5;
        while (n >= currentMultiple) {
            zeroCount += (n / currentMultiple);
            currentMultiple *= 5;
        }
        return zeroCount;
    }

    private static void rotate(int[] nums, int k) {
        k = k % nums.length;
        if(k == 0) return;
        int count = nums.length % k;
        if(count == 0) count = k;
        int changeCount = 0;

        for(int start = 0; start < count && changeCount < nums.length; start++){
            int i = start;
            int pre;
            int fix = nums[start];
            int next;
            do{
                next = (i + k) % nums.length;
                pre = fix;
                fix = nums[next];
                if(i == start){
                    nums[next] = nums[i];
                } else {
                    nums[next] = pre;
                }
                changeCount++;
                i += k;
            } while(next != start);
        }
    }

}
