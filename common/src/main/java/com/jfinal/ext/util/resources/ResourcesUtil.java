package com.jfinal.ext.util.resources;

import java.io.IOException;
import java.io.InputStream;

/*
    author: 江理网猿
    date: 2020/10/18 0018
*/
public class ResourcesUtil {

    public static String getFirstUsed(String[] fileNames){
        ClassLoader classLoader = ResourcesUtil.class.getClassLoader();
        for (String fileName : fileNames) {
            InputStream in = classLoader.getResourceAsStream(fileName);
            if(null != in){
                try { in.close(); } catch (IOException ignored) {}
                return fileName;
            }
        }
        return null;
    }
}
