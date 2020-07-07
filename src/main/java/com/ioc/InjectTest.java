package com.ioc;

import org.junit.Test;

import javax.inject.Inject;

/**
 * @Author: Hiccup
 * @Date: 2020/6/11 16:23
 */
public class InjectTest {

    private static InjectDemo injectDemo;

    @Inject
    public InjectTest(InjectDemo injectDemo) {
        this.injectDemo = injectDemo;
    }

    @Test
    public void test(){
        injectDemo.test();
    }

}
