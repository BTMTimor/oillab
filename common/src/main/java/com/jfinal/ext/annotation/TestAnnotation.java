package com.jfinal.ext.annotation;

import java.util.function.ObjDoubleConsumer;

/*
    author: Timor
    date: 2020/2/20 0020
*/
public @interface TestAnnotation {
    String value() default "";
}
