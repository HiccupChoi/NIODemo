package com.threadpool;

/**
 * @Author: Hiccup
 * @Date: 2019/8/8 11:33 AM
 * ThreadPoolExecutor demo 练习
 */
public class ThreadPoolDemo {

    /**
     * ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, milliseconds, runnableTaskQueue, handler)
     * ThreadPoolExecutor 参数：
     * corePoolSize 线程池基本大小
     * maximumPoolSize 线程池最大数量
     * runnableTaskQueue 任务队列
     *      1. ArrayBlockingQueue
     *      2. LinkedBlockingQueue
     *      3. SynchronousQueue
     *      4. PriorityBlockingQueue
     * keepAliveTime 线程活动保持时间
     * RejectedExecutionHandler handler 饱和策略（超出线程池最大数量后的处理）
     */
    public static void main(String[] args) {
//        new ThreadPoolExecutor();
    }

    private void submit(){

    }

}
