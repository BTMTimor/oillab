package com.oillab.admin.controller;

import com.jfinal.aop.Inject;
import com.jfinal.core.ActionKey;
import com.jfinal.ext.annotation.RequestMapping;
import com.jfinal.ext.common.api.result.ApiResult;
import com.jfinal.ext.common.api.result.ResultCode;
import com.jfinal.ext.common.controller.BaseViewController;
import com.jfinal.ext.common.service.BaseService;
import com.jfinal.ext.token.MyToken;
import com.jfinal.ext.token.MyTokenManager;
import com.jfinal.kit.StrKit;
import com.oillab.admin.model.Admin;
import com.oillab.admin.service.AdminService;

/*
    author: Timor
    date: 2020/2/7 0007
*/
@RequestMapping(value = "/admin", viewPath = "/view/backstage/admin")
public class AdminController extends BaseViewController<Admin> {
    @Inject private AdminService service;

    public void index() {
        String uid = getUserId();
        if(StrKit.notBlank(uid)){
            Admin admin = service.findById(uid);
            setAttr("user", admin);
            System.out.println("[AdminController] admin: " + admin);
            render("index.html");
            return;
        }
        redirect("/login");
    }

    public void index2() {
        String uid = getUserId();
        if(StrKit.notBlank(uid)){
            Admin admin = service.findById(uid);
            setAttr("user", admin);
            System.out.println("[AdminController] admin: " + admin);
            render("index2.html");
            return;
        }
        redirect("/login");
    }

    @Override
    public void add() {
        super.add();
    }

    public void update(String id) {
        super.edit(id);
    }

    @Override
    public void list() {
        super.list();
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @ActionKey("/admin/role/list")
    public void roleList() {
        render("role.html");
    }

    @ActionKey("/admin/permission/list")
    public void permissionList() {
        render("permission.html");
    }


    // 登录及注销
    // - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @ActionKey("/login")
    public void login(){
        if(isPostRequest()){
            // String vCode = get("vCode");
            // validateVCode(vCode)
            if (validateCaptcha("vCode")) {
                String username = get("username");
                String password = get("password");
                loginByPassword(username, password);
            }else {
                renderJson(ApiResult.failure(ResultCode.USER_V_CODE_ERROR));
            }
        }else{
            render("login.html");
        }
    }

    @ActionKey("/simpleLogin")
    public void simpleLogin(){
        render("simpleLogin.html");
    }

    /**
     * 通过用户名和密码单点登录
     * @param username 用户名
     * @param password 密码
     */
    private void loginByPassword(String username, String password){
        Admin user = service.login(username, password);
        if(user != null){
            MyToken token = MyTokenManager.createToken(this, user.getId());
            renderJson(ApiResult.success(token.getUid()));
        }else{
            renderJson(ApiResult.failure(ResultCode.USER_LOGIN_ERROR, "账号或密码错误"));
        }
        System.out.println("[AdminController] " + username
                + ": login( " + (user != null ? "success" : "error") + ")");
    }

    // 退出登录
    @ActionKey("/logout")
    public void logout(){
        MyTokenManager.clearToken(this);
        render("login.html");
    }

    @ActionKey("captcha/login")
    public void loginCaptcha(){
        renderCaptcha();
        // sendImgCode();
    }

    public void dashboard(){
        render("dashboard.html");
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @Override
    protected BaseService<Admin> getService() {
        return service;
    }
}
