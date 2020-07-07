package com.ioc;


import com.google.inject.AbstractModule;

/**
 * @Author: Hiccup
 * @Date: 2020/6/11 16:23
 */
public class InjectDemo extends AbstractModule {

    @Override
    protected void configure() {
        bind(InjectDemo.class).to(InjectDemo.class);
    }

    public void test(){
        System.out.println("xxxxxxxxxx");
    }
}
