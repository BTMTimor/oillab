package com.jfinal.ext.handel;

import com.jfinal.handler.Handler;
import com.jfinal.kit.StrKit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
    伪静态处理器
    author: Timor
    date: 2020/7/13 0013
*/
public class FakeStaticHandler extends Handler {
    private final String viewPostfix;

    public FakeStaticHandler() {
        this.viewPostfix = ".html";
    }

    public FakeStaticHandler(String viewPostfix) {
        if (StrKit.isBlank(viewPostfix)) {
            throw new IllegalArgumentException("viewPostfix can not be blank.");
        } else {
            this.viewPostfix = viewPostfix;
        }
    }

    @Override
    public void handle(String target, HttpServletRequest request, HttpServletResponse response, boolean[] isHandled) {
        if ("/".equals(target) || !target.contains(".")) {
            this.next.handle(target, request, response, isHandled);
        } else {
            int index = target.lastIndexOf(this.viewPostfix);
            if (index != -1) {
                target = target.substring(0, index);
            }

            this.next.handle(target, request, response, isHandled);
        }
    }
}

