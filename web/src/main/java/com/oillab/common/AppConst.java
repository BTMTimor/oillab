package com.oillab.common;

import com.jfinal.ext.kit.JFinalKit;

/*
    author: Timor
    date: 2019/12/13 0013
*/
public class AppConst {
    public static final String USER_TOKEN = "token";
    public static final String USER_ID = "uid";
    private static final String DOMAIN_NAME = "";

    public AppConst() {
    }

    public static String getUploadPath() {
        return JFinalKit.getConstants().getBaseUploadPath();
    }

    public static String getDownloadPath() {
        return JFinalKit.getConstants().getBaseDownloadPath();
    }

    public static String getServerAddress(){
        return DOMAIN_NAME;
    }

    public static String getPubDir() {
        return "";
    }
}
