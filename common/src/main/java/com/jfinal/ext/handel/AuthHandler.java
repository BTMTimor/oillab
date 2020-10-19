package com.jfinal.ext.handel;

import com.jfinal.ext.token.MyToken;
import com.jfinal.ext.token.MyTokenManager;
import com.jfinal.ext.util.server.CookiesUtil;
import com.jfinal.handler.Handler;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
    author: Timor
    date: 2019/12/3 0003

    处理用户认证
*/
public class AuthHandler extends Handler {

    @Override
    public void handle(String target, HttpServletRequest request, HttpServletResponse response, boolean[] booleans) {
        if(target.startsWith("/view/")){
            try {
                response.sendError(404);
            } catch (IOException ignored) { }
            next.handle(target, request, response, new boolean[]{true});
            return;
        }

        if(target.contains(".")){
            next.handle(target, request, response, booleans);
            return;
        }

        /*// 本项目除验证码外不适应session
        HttpSession session = request.getSession(false);
        // 已登录
        if(null != session){
            request.setAttribute(MyToken.USER_ID, session.getAttribute(CommonConfig.SESSION_USER_ID));
            next.handle(target, request, response, booleans);
            return;
        }*/

        // 未登录，尝试从cookies恢复登录
        Cookie cookie = CookiesUtil.getCookie(request, MyToken.TOKEN_NAME);
        if(null != cookie){
            MyToken token = MyTokenManager.validateToken(cookie.getValue());
            if(null != token){
                // 传递user_id，方便后边业务功能
                request.setAttribute(MyToken.USER_ID, token.getUid());
                System.out.println("[AuthHandler: user]: " + token.getUid());
                response.addCookie(MyTokenManager.updateTokenToCookie(token));
            }else {
                String temp = "{ip: " + request.getRemoteAddr() + ", port: " + request.getRemotePort() + "}";
                System.out.println("[AuthHandler: 游客] " + temp);
            }
        }

        next.handle(target, request, response, booleans);
    }
}
