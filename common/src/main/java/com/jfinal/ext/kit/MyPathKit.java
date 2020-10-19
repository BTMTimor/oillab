package com.jfinal.ext.kit;

import com.jfinal.kit.PathKit;

import java.io.File;

/*
    author: 江理网猿
    date: 2020/9/4 0004
*/
public class MyPathKit extends PathKit {

    public static String getRootPath(){
        String webRootPath = getWebRootPath();
        return webRootPath
                .substring(0, webRootPath.lastIndexOf(File.separator));
    }

    public static String getJavaPath(){
        String webRootPath = getWebRootPath();
        return webRootPath
                .substring(0, webRootPath.lastIndexOf(File.separator) + 1)
                + "java";
    }


    public static String getResourcePath(){
        String webRootPath = getWebRootPath();
        return webRootPath
                .substring(0, webRootPath.lastIndexOf(File.separator) + 1)
                + "resources";
    }

}
