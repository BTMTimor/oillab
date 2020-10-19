package com.jfinal.ext.handel;

import com.jfinal.handler.Handler;
import com.jfinal.kit.StrKit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
    author: Timor
    date: 2020/1/15 0015

    通过设置header，解决跨域问题
*/
public class CrossDomainHandler extends Handler {
    @Override
    public void handle(String s, HttpServletRequest request, HttpServletResponse response, boolean[] booleans) {
        String referer = request.getHeader("origin");
        if (StrKit.isBlank(referer)) {
            String origin = (String) request.getAttribute("ctx");
            response.addHeader("Access-Control-Allow-Origin", origin);
            response.addHeader("Access-Control-Allow-Credentials", "true");
        } else {
            response.addHeader("Access-Control-Allow-Origin", "*");
        }
        response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
        response.addHeader("Access-Control-Allow-Headers", "Content-Type");
        next.handle(s, request, response, booleans);
    }
}