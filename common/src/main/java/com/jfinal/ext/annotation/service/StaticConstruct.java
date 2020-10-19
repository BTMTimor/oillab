package com.jfinal.ext.annotation.service;

/*
    author: Timor
    date: 2020/7/14 0014
*/
import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface StaticConstruct {
    String value() default "";
}
