package com.jfinal.ext.util;

import com.jfinal.kit.StrKit;

import java.io.File;
import java.util.regex.Matcher;

/*
    author: Timor
    date: 2019/11/18 0018
*/
public class MyUtil {
    public static final String PATH_SEPARATOR = Matcher.quoteReplacement(File.separator);

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
        if(StrKit.isBlank(path.trim()) || path.matches("[/ \\\\]+")){
            return PATH_SEPARATOR;
        }
        if(processPointer) {
            path = path.replaceAll("\\.\\.", "");
        }
        path = path.replace("\\", "/");
        path = path.replaceAll("/+", PATH_SEPARATOR);
        return path;
    }

}
