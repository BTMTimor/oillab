package com.oillab.common.util;

import java.io.File;

/*
    author: Timor
    date: 2019/11/18 0018
*/
public class MyUtil {

    // 不处理非标准俩：”//www.baidu.com“
    public static String formatUrl(String url){
        return formatUrl(url, true);
    }

    // 不处理非标准俩：”//www.baidu.com“
    public static String formatUrl(String url, boolean processPointer){
        if(processPointer) {
            url = url.replaceAll("\\.\\.", "");
        }
        url = url.replace("\\", "/");
        url = url.replaceAll("/+", "/");
        url = url.replace(":/", "://");
        return url;
    }

    public static String formatPath(String path){
        return formatPath(path, true);
    }

    public static String formatPath(String path, boolean processPointer){
        if(processPointer) {
            path = path.replaceAll("\\.\\.", "");
        }
        path = path.replace("\\", "/");
        path = path.replaceAll("/+", File.separator);
        return path;
    }

}
