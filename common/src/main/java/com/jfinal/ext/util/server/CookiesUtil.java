package com.jfinal.ext.util.server;

import com.jfinal.kit.StrKit;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/*
    author: 江理网猿
    date: 2020/9/20 0020
*/
public class CookiesUtil {

    public static Cookie getCookie(HttpServletRequest request, String name) {
        if(null == request || StrKit.isBlank(name)){
            return null;
        }

        Cookie[] cookies = request.getCookies();
        if(null != cookies && cookies.length > 0){
            for (Cookie cookie : cookies) {
                String cname = cookie.getName();
                if (name.equals(cname)) {
                    return cookie;
                }
            }
        }
        return null;
    }
}
