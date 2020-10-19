package com.oillab.common.util;

/*
    author: 江理网猿
    date: 2020/10/7 0007
*/
public class Console {

    public static void log(Object...args){

    }

    public static void info(String format, Object...args){
        System.out.printf((format) + "%n", args);
    }
}
