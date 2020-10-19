package com.jfinal.ext.handel;

import com.jfinal.handler.Handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
    author: Timor
    date: 2019/12/11 0011

    角色/权限==》路由分发，目前暂时没做功能
*/
public class RouteDistributionHandel extends Handler {
    public static final String LOGIN_URL = "/login";
    @Override
    public void handle(String target, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, boolean[] booleans) {
        if(target.equals(LOGIN_URL)){
            System.out.println("[PermissionHandel] " + LOGIN_URL + ": user login...");
        }
        next.handle(target, httpServletRequest, httpServletResponse, booleans);
    }
}
