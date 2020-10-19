package com.oillab.admin.controller;

import com.jfinal.aop.Inject;
import com.jfinal.core.ActionKey;
import com.jfinal.core.paragetter.Para;
import com.jfinal.ext.annotation.RequestMapping;
import com.jfinal.ext.common.controller.BaseApiController;
import com.jfinal.ext.common.service.BaseService;
import com.oillab.admin.model.Admin;
import com.oillab.admin.service.AdminService;

/*
    author: Timor
    date: 2020/2/7 0007
*/
@RequestMapping(value = "/api/v1/admin")
public class AdminApiController extends BaseApiController<Admin> {
    @Inject private AdminService service;

    @Override
    protected BaseService<Admin> getService() {
        return service;
    }

    @ActionKey("/api/v1/admin/get")
    public void getAdminInfo() {
        renderJson(findById(getAttr(Admin.ID)));
    }

    public void add(@Para("") Admin admin) {

        // 填入AdminId、注册使劲按和账号状态
//        user.setId(MyUIDUtil.getUID());
//        user.setRegTime(new Date());
        // user.setLoginTime(Admin.DEFAULT_LOGIN_TIME);
        // 设置用户状态为正常状态
//        user.setStatus(Admin.Status.NORMAL.getStatus());
        renderJson(checkAndAdd(admin));
    }

    public void update(@Para("") Admin admin) {
        // 防止恶意修改他人信息
        admin.setId(getAttr(Admin.ID));
        renderJson(checkAndUpdate(admin));
    }

    /**
     * 用户注销账户（假删除）
     */
    public void delete() {
        renderJson(fakeDelete(getAttr(Admin.ID),
                (admin)-> admin.setStatus(Admin.Status.DELETE.getStatus())));
    }

    // 真删除
    public void realDelete() {
        renderJson(deleteById((String)getAttr(Admin.ID)));
    }

}
