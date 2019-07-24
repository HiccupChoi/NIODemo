package com.theadpool;

/**
 * @Author: 欢
 * @Date: 2019/6/24 4:34 PM
 */
public class Main {

    public static void main(String[] args) {
        DefaultThreadPool defaultThreadPool = new DefaultThreadPool();
        for (int i = 0; i < 100; i++) {
            Job job = new Job(i);
            defaultThreadPool.execute(job);
        }
    }
}
