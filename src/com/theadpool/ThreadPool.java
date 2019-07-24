package com.theadpool;

/**
 * @Author: Hiccup
 * @Date: 2019/6/24 4:04 PM
 */
public interface ThreadPool {

    /**
     * 执行一个job
     */
    void execute(Job job);

    /**
     * 关闭线程池
     */
    void shutDown();

    /**
     * 增加工作者线程
     * @param num 增加的数量
     */
    void addWorkers(int num);

    /**
     * 减少工作者线程
     * @param num 减少的数量
     */
    void removeWorker(int num);

    /**
     * 得到等待执行的任务数量
     */
    int getJobSize();
}
