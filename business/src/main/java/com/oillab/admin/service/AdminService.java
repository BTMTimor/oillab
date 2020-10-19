package com.oillab.admin.service;

import com.jfinal.ext.common.service.impl.BaseServiceImpl;
import com.oillab.admin.model.Admin;

/*
    author: Timor
    date: 2019/11/19 0019
*/
public class AdminService extends BaseServiceImpl<Admin> {

    public Admin login(String username, String password){
        return DAO.findFirst("select * from sys_user where username = ? && password = ? limit 1",
                username, password);
        /*String sql = "select id from sys_user where username = ? && password = ?";
        return Db.queryStr(sql, username, password);*/
    }

}