package com.concurrenthashmap;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * @Author: Hiccup
 * @Date: 2019/8/19 10:25 AM
 * 测试ConCurrentHashMap 的 putIfAbsent方法是否绝对线程安全
 */
public class PutIfAbSentTest {

    public static ConcurrentHashMap hashMap = new ConcurrentHashMap(16);

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(100);
        for (int i = 0; i < 100000; i++) {
            final int j = i;
            new Thread(() -> {
                try {
                    countDownLatch.await();
                    Object value = hashMap.putIfAbsent("1565316_1017103467_1565949526343", j);
                    if (value == null){
                        System.out.println("error");
                    }
                    System.out.println(j);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            countDownLatch.countDown();
        }
    }

}
