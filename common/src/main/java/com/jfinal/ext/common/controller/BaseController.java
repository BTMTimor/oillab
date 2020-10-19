package com.jfinal.ext.common.controller;

import com.alibaba.fastjson.JSONObject;
import com.jfinal.core.Controller;
import com.jfinal.ext.common.api.result.ApiResult;
import com.jfinal.ext.common.api.result.ResultCode;
import com.jfinal.ext.common.model.BaseModel;
import com.jfinal.ext.kit.JFinalKit;
import com.jfinal.ext.util.image.code.ImageCode;
import com.jfinal.ext.util.image.code.ImgCodeFactory;
import com.jfinal.ext.util.validate.MyMD5Util;
import com.jfinal.kit.HttpKit;
import com.jfinal.kit.JsonKit;
import com.jfinal.kit.StrKit;
import com.jfinal.log.Log;
import com.jfinal.plugin.activerecord.Model;
import org.app.config.CommonConfig;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
    author: Timor
    date: 2019/12/25 0025
*/
public class BaseController<T extends BaseModel<T>> extends Controller {
    public static final Log log = Log.getLog(BaseController.class);
    public static final String FIND_CONDITION = "condition";
    public static final String SESSION_VERIFICATION_CODE_KEY = "vCode";
    private static final String COOKIE_VERIFICATION_CODE_KEY = "vct";
    private static final String VCT_SALT = "HEY#(@&D?<?@M?A923M>CAH91U*#@(u135s!~gca(*(*8";
    public static final int DEFAULT_VCT_EXPIRE_TIME = 5 * 60;
    private static String serverAddr = null;
    private boolean isReadData = false;
    private String readData = "";

    public String getServer(){
        if(null == serverAddr){
            serverAddr = getRequest().getScheme() + "://" + getRequest().getServerName()
                    + (getRequest().getServerPort() == 80 ? "" : ":" + getRequest().getServerPort())
                    + getRequest().getContextPath();
            // 加到application中，这样所有页面都可以获取到了
            getRequest().getServletContext().setAttribute("serverAddr", serverAddr);
        }
        return serverAddr;
    }

    public String getUploadPath(){
        return JFinalKit.getConstants().getBaseDownloadPath();
    }

    public String getDownloadPath(){
        return JFinalKit.getConstants().getBaseDownloadPath();
    }

    @Override
    public String getPara() {
        if ("application/json".equals(getRequest().getContentType())
                || "text/json".equals(getRequest().getContentType())) {
            if(!isReadData){
                readData = HttpKit.readData(getRequest());
                isReadData = true;
            }
            return readData;
        }
        return super.getPara();
    }

    @Override
    public String getPara(String name) {
        HttpServletRequest request = getRequest();
        if("POST".equals(request.getMethod())){
            if ("application/json".equals(request.getContentType())
                    || "text/json".equals(request.getContentType())) {
                return JSONObject.parseObject(getPara()).getString(name);
            }
        }
        return super.getPara(name);
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    protected boolean isPostRequest() {
        return  ("POST".equalsIgnoreCase(getRequest().getMethod()));
    }


    // 其他：验证码
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    protected boolean isIgnoreVCodeCase(){
        return true;
    }

    protected void sendImgCode(){
        sendImgCode(DEFAULT_VCT_EXPIRE_TIME);
    }

    protected void sendImgCode(int expiredSeconds){
        sendImgCode(COOKIE_VERIFICATION_CODE_KEY, expiredSeconds);
    }

    protected void sendImgCode(String cookiesName){
        sendImgCode(cookiesName, DEFAULT_VCT_EXPIRE_TIME);
    }

    /**
     * 发送验证码
     * @param cookiesName 存验证码标识的额cookiesName
     * @param expiredSeconds 验证码过期时间
     */
    protected void sendImgCode(String cookiesName, int expiredSeconds){
        HttpServletResponse response = getResponse();
        String imgFormat = ImageCode.FORMAT_JPEG;
        // response.reset();
        response.setStatus(200);
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/" + imgFormat);

        ImageCode imageCode = ImgCodeFactory.newImageCode();

        String randCode = imageCode.getRandCode();
        if(isIgnoreVCodeCase()) {
            randCode = randCode.toLowerCase();
        }

        int expiredTime = (int) (System.currentTimeMillis() / 1000 + expiredSeconds);
        String vct = MyMD5Util.getMD5(VCT_SALT + "-" + randCode + "-" + expiredTime);

        // 将认证码存入SESSION及存储cookies
        setSessionAttr(cookiesName, randCode);
        setCookie(cookiesName, vct + "|" + expiredTime, expiredSeconds);

        // todo for test
        // System.out.println(VCT_SALT + "-" + randCode + "-" + expiredTime);
        // System.out.println("{vct: " + vct + ", expiredTime: " + expiredTime + ", vCode: " + randCode + "}");

        try {
            ServletOutputStream outputStream = response.getOutputStream();
            imageCode.writeImg(imgFormat, outputStream);
            outputStream.flush();
            renderNull();
        } catch (IOException exception) {
            log.warn(exception.getMessage());
        }
    }


    protected boolean validateVCode(String vCode){
        return validateVCode(COOKIE_VERIFICATION_CODE_KEY, vCode);
    }

    /**
     * 验证验证码是否正确
     * @param cookiesName 存验证码标识的额cookiesName
     * @param vCode 待校验的验证码
     * @return 验证码是否有效
     */
    protected boolean validateVCode(String cookiesName, String vCode){
        String temp = getCookie(cookiesName);
        if(StrKit.isBlank(temp) || StrKit.isBlank(vCode)) {
            return false;
        }
        String[] vcts = temp.split("\\|", 2);

        String cookieVCT;
        int expiredTime;
        if(2 == vcts.length){
            expiredTime = Integer.parseInt(vcts[1]);
            if((System.currentTimeMillis() / 1000) > expiredTime){
                return false;
            }
            cookieVCT = vcts[0];
        }else {
            return false;
        }

        if(isIgnoreVCodeCase()) {
            vCode = vCode.toLowerCase();
        }
        String vct = MyMD5Util.getMD5(VCT_SALT + "-" + vCode + "-" + expiredTime);

        // System.out.println(VCT_SALT + "-" + vCode + "-" + expiredTime);
        // System.out.println("{cookieVCT: " + cookieVCT + ", expiredTime: " + expiredTime + "}");
        // System.out.println("{      vct: " + vct + ", " + "vCode: " + vCode + "}");
        boolean isValidate = vct.equals(cookieVCT);
        if(isValidate) {
            setCookie(cookiesName, "", 0);
        }
        return isValidate;
    }


    // 其他：与具体业务相关
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    protected String getUserId(){
        // return getSessionAttr(SESSION_USER_ID);
        String userId = getAttr(CommonConfig.USER_FIELD_ID);
        System.out.println("userId: " + userId);
        if(StrKit.isBlank(userId)){
            HttpServletResponse response = getResponse();
            try {
                PrintWriter writer = response.getWriter();
                writer.print(JsonKit.toJson(ApiResult.error(ResultCode.USER_LOGIN_EXPIRE)));
                response.flushBuffer();
                writer.close();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return userId;
    }

    // 从session获取用户
    protected Model<?> getCurrentUser(){
        // 应通过user_id再获取用户 todo
        return getSessionAttr(CommonConfig.USER_FIELD);
    }


}
