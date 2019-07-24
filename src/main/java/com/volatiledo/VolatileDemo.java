package com.volatiledo;

/**
 * @Author: 欢
 * @Date: 2019/5/29 4:30 PM
 * 测试volatile可见性 并只可见标记volatile的属性
 * 不会刷新更改线程写入主内存中的全部属性
 */
public class VolatileDemo {

    private static boolean flag;
    private static volatile int a;

    public static void main(String[] args) {

        new Thread(() ->{
            System.out.println(a);
            System.out.println(flag);
            int b = a;
            boolean flbg = flag;

            //去主内存更新a的值
            while (b == a){

            }
            System.out.println(a);

            //去主内存更新flag的值
            while (flag == flbg){

            }
            System.out.println(flag);
        },"线程1").start();

        new Thread(() ->{
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //重写a的值
            a = 10;

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //重写flag的值
            flag = true;
        },"线程2").start();

    }

}
