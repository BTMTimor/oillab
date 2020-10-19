package com.jfinal.ext.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jfinal.ext.common.api.result.ApiResult;
import com.jfinal.ext.common.api.result.ResultCode;
import com.jfinal.ext.kit.JFinalKit;

/*
    author: Timor
    date: 2020/2/9 0009
*/
public class ExceptionInterceptor implements Interceptor {

    @Override
    public void intercept(Invocation invocation) {
        ApiResult result = null;
        Controller controller = invocation.getController();
        try {
            invocation.invoke();
            // 生产模式
            if(!JFinalKit.getConstants().getDevMode()) { return; }
            // 已经发送出去了
            if(controller.getResponse().isCommitted()) { return; }

            int status = controller.getResponse().getStatus();
            // 4xx, 5xx都是发生错误
            if((status / 100) > 3){
                result = ApiResult.error(status);
            }
        } catch (NullPointerException e) {
            processException(e);
            result = ApiResult.error(ResultCode.PARAM_IS_MISSING, e.getMessage());
        } catch(SecurityException e){
            processException(e);
            result = ApiResult.error(ResultCode.PERMISSION_NO_ACCESS, e.getMessage());
        } catch (Exception e){
            processException(e);
            result = ApiResult.error(ResultCode.SYSTEM_INNER_ERROR, e.getMessage());
        }finally {
            if(null != result){
                // 返回统一格式json数据
                try {
                    controller.renderJson(result);
                }catch (Exception ignore){}
            }

        }
    }

    protected void processException(Exception e){
        if(JFinalKit.getConstants().getDevMode()){
            e.printStackTrace();
        }else{
            e.printStackTrace();
        }
    }
}
