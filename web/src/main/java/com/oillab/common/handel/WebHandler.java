package com.oillab.common.handel;

import com.jfinal.handler.Handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
    author: Timor
    date: 2019/12/25 0025
*/
public class WebHandler extends Handler {
    @Override
    public void handle(String s, HttpServletRequest request, HttpServletResponse response, boolean[] booleans) {
        final String ctx = request.getScheme() + "://" + request.getServerName()
                    + (request.getServerPort() == 80 ? "" : ":" + request.getServerPort())
                    + request.getContextPath();
        request.setAttribute("ctx" , ctx);
//        request.setAttribute("ctx", request.getContextPath());
        next.handle(s, request, response, booleans);

    }
}
