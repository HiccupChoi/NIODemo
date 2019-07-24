package com.thread;

/**
 * @Author: Hiccup
 * @Date: 2019/4/16 2:16 PM
 */
public class ThreadTest {

    private static boolean isOver = true;

    public static void main(String[] args) {

        new Thread(() -> {
            if (isOver){
                try {
                    isOver = false;
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    isOver = true;
                }
            }
        },"线程1").start();

        new Thread(() -> {
            try {
                if (isOver){
                    isOver = false;
                    System.out.println(Thread.currentThread().getName());
                    isOver = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"线程2").start();
    }

}
