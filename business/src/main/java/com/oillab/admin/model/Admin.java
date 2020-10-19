package com.oillab.admin.model;

import com.common.base.model.generate.BaseUser;
import com.jfinal.ext.annotation.TableBind;
import com.jfinal.ext.annotation.TableColDesc;
import com.jfinal.ext.annotation.TableDesc;


/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
@TableBind(tableName = "sys_user", primaryKey = "id")
@TableDesc(label = "管理员", width = "100%", height = "675px")
public class Admin extends BaseUser<Admin> {
    @TableColDesc(name = "id", paraName = "id", label = "id", type = "text")
    public static final String ID = "id";
    @TableColDesc(name = "username", paraName = "username", label = "用户名", type = "text")
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    @TableColDesc(name = "status", paraName = "status", label = "状态", type = "number", format = "statusFmt")
    public static final String STATUS = "status";


    public enum Status{
	    FORBIDDEN(-1), WAITING_FOR_CHECK(0), NORMAL(1), DELETE(2);

	    private final int status;

        Status(int status) {
            this.status = status;
        }

        public int getStatus() {
            return status;
        }
    }

    public boolean valid() {

	    return true;
    }

    @Override
    public Admin filterForReturn() {
        return remove(PASSWORD);
    }
}