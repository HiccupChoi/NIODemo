package com.lambda;

import java.util.function.Predicate;

/**
 * @Author: Hiccup
 * @Date: 2019/11/14 6:08 下午
 */
public class Test {

    public static void main(String[] args) {
        Predicate<Integer> predicate = x -> x > 185;
        boolean bo = predicate.test(175);
        System.out.println(bo);
    }

}
