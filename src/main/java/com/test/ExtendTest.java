package com.test;

/**
 * @Author: Hiccup
 * @Date: 2019/11/20 5:30 下午
 */
class Test {

    private String testString;

    public Test() {
        System.out.println("father");
    }

    public Test(String testString) {
        System.out.println("father++");
        this.testString = testString;
    }
}


class testSun extends Test{

    public testSun() {

    }

    public static void main(String[] args) {
        testSun sun = new testSun();
    }
}