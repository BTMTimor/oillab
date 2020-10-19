package org.app.config;

import com.jfinal.ext.kit.JFinalKit;

/*
    author: 江理网猿
    date: 2020/9/10 0010
*/
public class CommonConfig {
    public static final String USER_FIELD = "user";
    public static final String USER_FIELD_ID = "uid";
    public static final String SESSION_USER = "user";
    public static final String SESSION_USER_ID = "user_id";
    public static final String COOKIES_USER_ID = "user_id";
    public static final String TOKEN_NAME = "ut";// user token
    public static final int TOKEN_TIME_OUT = 3 * 60 * 60 * 1000;// 3h
    public static final int DEFAULT_REFRESH_LIMIT = 50;// 50毫秒
    private static final String TOKEN_SLAT = "wdf#vb9i!ugf5t$-yhj*76tr3+r-tg^bn";


    public static String getTokenSlat() {
        return TOKEN_SLAT;
    }


    public static String getUploadPath() {
        return JFinalKit.getConstants().getBaseUploadPath();
    }

    public static String getDownloadPath() {
        return JFinalKit.getConstants().getBaseDownloadPath();
    }

    public static String getServerAddress() {
        return "";
    }
}
