package com.instruct;

/**
 * @Author: Hiccup
 * @Date: 2019/5/27 3:40 PM
 * 验证指令重排序问题
 * 大多数现代微处理器都会采用将指令乱序执行（out-of-order execution，简称OoOE或OOE）的方法，在条件允许的情况下，
 * 直接运行当前有能力立即执行的后续指令，避开获取下一条指令所需数据时造成的等待3。通过乱序执行的技术，处理器可以大大提高执行效率。
 */
public class InstructSort {
    static int x = 0, y = 0;
    static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(() -> {
            a = 1;
            x = b;
        });

        Thread threadTwo = new Thread(() -> {
            b = 2;
            y = a;
        });

        threadTwo.start();
        threadOne.start();

        threadOne.join();
        threadTwo.join();

        System.out.println(x + " " + y);
    }

}
