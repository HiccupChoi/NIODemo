package com.volatiledo;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Author: Hiccup
 * @Date: 2019/5/30 3:51 PM
 */
public class Cas {
    private static volatile AtomicBoolean atomicBoolean;

    public static void main(String[] args) {
        atomicBoolean.compareAndSet(false, true);
    }
}
