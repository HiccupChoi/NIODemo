package com.annotation.runtime;

import java.lang.reflect.Method;

public class AnnotationProcessor {

    public static void main(String[] args) {
        Method[] methods = AnnotationTest.class.getDeclaredMethods();
        for (Method m : methods) {
            Get get = m.getAnnotation(Get.class);
            System.out.println(get.value());
        }
    }
}
