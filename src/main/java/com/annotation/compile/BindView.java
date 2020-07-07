package com.annotation.compile;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author: Hiccup
 * @Date: 2020/6/12 10:59
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.FIELD)
public @interface BindView {
}
