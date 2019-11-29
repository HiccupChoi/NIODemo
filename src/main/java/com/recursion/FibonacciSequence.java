package com.recursion;

/**
 * @Author: Hiccup
 * @Date: 2019/11/13 10:43 上午
 * 使用递归实现斐波那契数列
 */
public class FibonacciSequence {

    public static void main(String[] args) {
        for (int i = 1; i < 21; i++) {
            System.out.print(FibonacciSequenceRecursion(i) + "  ");
        }
    }

    private static int FibonacciSequenceRecursion(int n){
        if (n <= 2){
            return 1;
        }
        return FibonacciSequenceRecursion(n - 1) + FibonacciSequenceRecursion(n - 2);
    }

}
