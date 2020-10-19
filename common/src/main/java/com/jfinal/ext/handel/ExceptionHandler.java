package com.jfinal.ext.handel;

import com.jfinal.handler.Handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
    author: Timor
    date: 2020/2/9 0009
*/
public class ExceptionHandler extends Handler {

    @Override
    public void handle(String target, HttpServletRequest request, HttpServletResponse response, boolean[] isHandled) {
        next.handle(target, request, response, isHandled);
    }

}
