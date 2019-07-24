package com.theadpool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author: 欢
 * @Date: 2019/6/19 11:53 AM
 */
public class DefaultThreadPool implements ThreadPool {

    /**
     * 线程池最大限制数
     */
    private static final int MAX_WORKER_NUMBERS = 10;
    /**
     * 线程池默认数
     */
    private static final int DEFAULT_WORKER_NUMBERS = 5;
    /**
     * 线程池最小数
     */
    private static final int MIN_WORKER_NUMBERS = 1;
    /**
     * 工作列表
     */
    private final LinkedList<Job> jobs = new LinkedList<>();
    /**
     * 工作者列表
     */
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<>());
    /**
     * 工作者数量
     */
    private int workerNum = DEFAULT_WORKER_NUMBERS;
    /**
     * 工作线程编号
     */
    private AtomicLong threadNum = new AtomicLong();

    DefaultThreadPool() {
        initWorkers(DEFAULT_WORKER_NUMBERS);
    }

    public DefaultThreadPool(int workerNum){
        this.workerNum = workerNum > MAX_WORKER_NUMBERS ? MAX_WORKER_NUMBERS : workerNum < MIN_WORKER_NUMBERS ? MIN_WORKER_NUMBERS : workerNum;
        initWorkers(this.workerNum);
    }

    /**
     * 初始化线程工作者
     * @param num 初始化工作者线程数量
     */
    private void initWorkers(int num){
        for (int i = 0; i < num; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker, "DefaultThreadPool-Worker-" + threadNum.incrementAndGet());
            thread.start();
        }
    }


    /**
     * 添加一个工作，然后发通知
     * @param job 需要执行的任务
     */
    @Override
    public void execute(Job job) {
        if (job != null){
            synchronized (jobs){
                jobs.addLast(job);
                jobs.notify();
            }
        }
    }

    @Override
    public void shutDown() {
        for(Worker worker : workers){
            worker.shutDown();
        }
    }

    @Override
    public void addWorkers(int num) {
        synchronized (jobs){
            if (num + this.workerNum > MAX_WORKER_NUMBERS){
                num = MAX_WORKER_NUMBERS - this.workerNum;
            }
            initWorkers(num);
            this.workerNum += num;
        }
    }

    @Override
    public void removeWorker(int num) {
        synchronized (jobs){
            if (num > this.workerNum){
                throw new IllegalArgumentException("beyond WorkNum");
            }
            int count = 0;
            while (count < num){
                Worker worker = workers.get(count);
                if (workers.remove(worker)){
                    worker.shutDown();
                    count++;
                }
            }
            this.workerNum -= count;
        }
    }

    @Override
    public int getJobSize() {
        return jobs.size();
    }

    class Worker implements Runnable {
        /**
         * 是否工作
         */
        private volatile boolean running = true;

        @Override
        public void run() {
            while (running){
                Job job = null;
                synchronized (jobs){
                    while (jobs.isEmpty()){
                        try {
                            jobs.wait();
                        } catch (InterruptedException ex){
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    job = jobs.removeFirst();
                }
                if (job != null){
                    job.run();
                }
            }
        }

        void shutDown(){
            running = false;
        }
    }

}
