package com.recursion;

/**
 * @Author: Hiccup
 * @Date: 2019/11/13 11:20 上午
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Frog {

    public static void main(String[] args) {
        for (int i = 1; i < 20; i++) {
            System.out.println(frogJump(i));
        }
    }

    private static int frogJump(int n){
        if (n <= 2){
            return n;
        }
        return frogJump(n - 1) + frogJump(n - 2);
    }

}
