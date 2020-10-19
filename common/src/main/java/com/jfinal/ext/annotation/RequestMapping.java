package com.jfinal.ext.annotation;

import java.lang.annotation.*;

/*
    author: Timor
    date: 2020/7/14 0014
*/
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface RequestMapping{
    //String controllerKey();
    String value();

    String viewPath() default "";
}
