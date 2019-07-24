package com.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @Author: Hiccup
 * @Date: 2019/7/19 3:48 PM
 */
public class ForkJoinDemo extends RecursiveTask {

    /**
     * 阈值
     */
    private static final int THRESHOLD = 2;
    /**
     * 开始位置
     */
    private int start;
    /**
     * 结束位置
     */
    private int end;

    private ForkJoinDemo(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Object compute() {
        int sum = 0;
        // 是否继续拆分任务
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute){
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            int middle = (start + end) / 2;
            ForkJoinDemo leftForkJoin = new ForkJoinDemo(start, middle);
            ForkJoinDemo rightForkJoin = new ForkJoinDemo(middle + 1, end);
            leftForkJoin.fork();
            rightForkJoin.fork();
            int leftResult = (int) leftForkJoin.join();
            int rightResult = (int) rightForkJoin.join();

            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        int count = 1000000;

        ForkJoinDemo forkJoinDemo = new ForkJoinDemo(1,count);

        ForkJoinTask result = forkJoinPool.submit(forkJoinDemo);

        System.out.println(result.get());

    }
}
