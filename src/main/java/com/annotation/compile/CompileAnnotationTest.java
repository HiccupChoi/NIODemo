package com.annotation.compile;

/**
 * @Author: Hiccup
 * @Date: 2020/6/12 14:49
 */
public class CompileAnnotationTest {

    @BindView
    private String bindView;

    public CompileAnnotationTest(String bindView) {
        this.bindView = bindView;
    }

    public static void main(String[] args) {
        new CompileAnnotationTest("1");
    }

}
