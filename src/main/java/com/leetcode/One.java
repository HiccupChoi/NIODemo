package com.leetcode;

/**
 * @Author: Hiccup
 * @Date: 2019/8/14 21:28
 * 保证线程按照顺序执行
 * 不论启动顺序,线程必须按照 one -> two -> three 顺序执行
 */
public class One {
    private static boolean first;
    private static boolean second;
    private static final Object lock = new Object();

    public static void main(String[] args) {

        Thread threadOne = new Thread(() -> {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName());
                first = true;
                lock.notifyAll();
            }
        },"thread-1");

        Thread threadTwo = new Thread(() -> {
            synchronized (lock) {
                if (!first) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName());
                second = true;
                lock.notifyAll();
            }
        },"thread-2");

        Thread threadThree = new Thread(() -> {
            synchronized (lock){
                if (!second){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName());
            }
        },"thread-3");

        for (int i = 1; i < 4; i++) {
            switch (i){
                case 1:
                    threadOne.start();
                    break;
                case 3:
                    threadTwo.start();
                    break;
                case 2:
                    threadThree.start();
                    break;
                default:
                    break;
            }
        }

    }


}
