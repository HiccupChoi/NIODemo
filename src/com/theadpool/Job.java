package com.theadpool;

/**
 * @Author: 欢
 * @Date: 2019/6/19 11:59 AM
 */
public class Job implements Runnable {
    private int num;

    public Job(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println(num);
    }
}
