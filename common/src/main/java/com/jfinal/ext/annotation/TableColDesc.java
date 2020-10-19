package com.jfinal.ext.annotation;

/*
    author: Timor
    date: 2020/2/11 0011
*/

import java.lang.annotation.*;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface TableColDesc {
    String name();//字段名称
    String paraName();//参数名称
    String label() default ""; //中文名称
    // text|file|textarea|password|color|date|datetime|datetime-local|email|month|number|range|search|tel|time|url|week|
    String type() default "text";
    String javaType() default "String";
    String cssClass() default ""; //HTML组件Class
    int width() default 100; //list宽度
    int minWidth() default -1; //最小值
    int maxWidth() default -1; //最大值
    boolean isDate() default false;//是否日期控件
    String format() default "";// 渲染格式
    String dateFormat() default "";//日期格式
    String remark() default ""; //备注
    boolean show() default true; // hidden/show
    boolean required() default true; // hidden/show
}
