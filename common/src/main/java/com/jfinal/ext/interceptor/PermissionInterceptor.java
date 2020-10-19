package com.jfinal.ext.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jfinal.ext.common.api.result.ApiResult;
import com.jfinal.ext.common.api.result.ResultCode;
import com.jfinal.ext.kit.PermissionKit;
import com.jfinal.ext.util.server.IpUtils;
import com.jfinal.kit.StrKit;
import org.app.config.CommonConfig;

import java.util.HashMap;
import java.util.Map;

/*
    author: Timor
    date: 2019/12/12 0012
*/
public class PermissionInterceptor implements Interceptor {
    private static final Map<String, Boolean> access = new HashMap<>(64);
    public static final String LOGIN_URL = "/login";

    @Override
    public void intercept(Invocation invocation) {
        String uri = invocation.getActionKey();
        Controller controller = invocation.getController();
        String userId = controller.getAttr(CommonConfig.USER_FIELD_ID);
        String clientIP = IpUtils.getClientIP(controller.getRequest());
        boolean isLogin = StrKit.notBlank(userId);
        boolean access = isLogin || hasPermissions(uri);

        if(!(isLogin || access)) {
            System.out.println("[permission] false ip: " + clientIP + ": " + uri);
            if(uri.startsWith("/api/")){
                controller.renderJson(ApiResult.error(ResultCode.PERMISSION_NO_ACCESS));
                // throw new SecurityException("没有权限访问或接口不存在");
            }else{
                controller.redirect(LOGIN_URL);
            }
            return;
        }else{
             System.out.println("[permission] true  ip: " + clientIP + ": " + uri + "; user: " + userId);
        }
        invocation.invoke();
    }

    public boolean hasPermissions(String uri){
        if(null == access.get(uri)){
            access.put(uri, PermissionKit.me().hasPermissions(uri));
        }
        return access.get(uri);
    }
}
