package com.future;


import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @Author: Hiccup
 * @Date: 2019/8/29 10:07 AM
 * FutureTaskTest 使用
 */
public class FutureTaskTest {

    /**
     * 存放Future任务
     */
    private final ConcurrentHashMap<Object, Future<String>> taskCache = new ConcurrentHashMap<>();


    public static void main(String[] args) {

    }

    @SuppressWarnings("unused")
    private String executionTask(final String taskName) throws ExecutionException, InterruptedException {
        Future<String> future = taskCache.get(taskName);
        if (future == null){
            Callable<String> task = () -> taskName;

            FutureTask<String> futureTask = new FutureTask<>(task);
            future = taskCache.putIfAbsent(taskName, futureTask);
            if (future == null){
                future = futureTask;
                futureTask.run();
            }
        }

        try {
            return future.get();
        } catch (CancellationException e){
            taskCache.remove(taskName);
        }
        return "";
    }

}
