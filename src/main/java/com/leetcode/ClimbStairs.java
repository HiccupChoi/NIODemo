package com.leetcode;

/**
 * @Author: Hiccup
 * @Date: 2020/6/24 14:18
 */
public class ClimbStairs {

    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for (int i = 1; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
