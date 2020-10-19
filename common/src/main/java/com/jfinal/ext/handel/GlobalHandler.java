package com.jfinal.ext.handel;

import com.jfinal.handler.Handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
    author: Timor
    date: 2020/2/8 0008
*/
public class GlobalHandler extends Handler {

    @Override
    public void handle(String uri, HttpServletRequest request, HttpServletResponse response, boolean[] booleans) {
        final String ctx = request.getScheme() + "://" + request.getServerName()
                + (request.getServerPort() == 80 ? "" : ":" + request.getServerPort())
                + request.getContextPath();
        request.setAttribute("ctx" , ctx);

        // 开始计时时间
//        long startTime = System.currentTimeMillis();
        try {
            next.handle(uri, request, response, booleans);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(111111);
        }
        // 处理结束时间
//        long endTime = System.currentTimeMillis();
//        // 总耗时
//        Long timeConsume = endTime - startTime;
//        System.out.println("[timeConsume] " + uri + " : " + timeConsume + "ms");
    }
}
