package com.waitAndNotify;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: Hiccup
 * @Date: 2019/12/24 10:15
 */
public class ConnectionTest {

    /**
     * 初始化连接池，数量为10
     */
    private static ConnectionPool pool = new ConnectionPool(10);
    /**
     * 所有线程同时启动
     */
    private static CountDownLatch start = new CountDownLatch(1);

    private static CountDownLatch end;

    @Test
    public void connectionTest() throws InterruptedException {
        int threadCount = 40;
        end = new CountDownLatch(threadCount);
        int count = 10;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();

        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new ConnectionRunnable(count, got, notGot), "thread-" + i);
            thread.start();
        }

        start.countDown();
        end.await();
        System.out.println("total invoke:" + (threadCount * count));
        System.out.println("got:" + got.get());
        System.out.println("notGet:" + notGot.get());
    }

    static class ConnectionRunnable implements Runnable {
        int count;
        AtomicInteger got;
        AtomicInteger notGot;

        ConnectionRunnable(int count, AtomicInteger got, AtomicInteger notGot) {
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }

        @Override
        public void run() {
            try {
                start.await();
            } catch (Exception ignored){

            }

            while (count > 0){
                try {
                    Connection connection = pool.fetchConnection(1000);
                    if (connection != null){
                        try {
                            connection.createStatement();
                            connection.commit();
                        } finally {
                            pool.releaseConnectiin(connection);
                            got.incrementAndGet();
                        }
                    } else {
                        notGot.incrementAndGet();
                    }
                } catch (InterruptedException | SQLException e) {
                    e.printStackTrace();
                } finally {
                    count--;
                }
            }
            end.countDown();
        }

    }



}
