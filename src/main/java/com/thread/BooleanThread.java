package com.thread;

/**
 * @Author: Hiccup
 * @Date: 2019/4/16 2:16 PM
 */
public class BooleanThread implements Runnable {

    private volatile boolean changeBoolean = true;

    @Override
    public void run() {
        if (changeBoolean){
            try {
                changeBoolean = false;
                Thread.sleep(1000);
                System.out.println("1");
                changeBoolean = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
