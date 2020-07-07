package com.leetcode;

/**
 * @Author: Hiccup
 * @Date: 2020/6/24 11:49
 */
public class MySqrt {

    public static void main(String[] args) {
        System.out.println(mySqrtCalc(3));
    }

    public static int mySqrtCalc(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long)mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return ans;
    }

}
