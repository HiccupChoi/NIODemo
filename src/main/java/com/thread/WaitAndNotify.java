package com.thread;

/**
 * @Author: Hiccup
 * @Date: 2019/9/2 5:14 PM
 * 验证notify()是否是公平的
 */
public class WaitAndNotify {
    /**
     * 共享资源
     */
    private static final Object RESOURCE = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            synchronized (RESOURCE){
                System.out.println("ThreadA get resource Lock");
                try {
                    System.out.println("ThreadA begin wait");
                    RESOURCE.wait();
                    System.out.println("ThreadA wait end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread-A").start();

        new Thread(() -> {
            synchronized (RESOURCE){
                System.out.println("ThreadB get resource Lock");
                try {
                    System.out.println("ThreadB begin wait");
                    RESOURCE.wait();
                    System.out.println("ThreadB wait end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread-B").start();

        Thread threadC = new Thread(() -> {
            synchronized (RESOURCE){
                System.out.println("ThreadC begin notify");
                RESOURCE.notify();
            }
        }, "Thread-C");

        Thread.sleep(1000);
        threadC.start();

    }

}
