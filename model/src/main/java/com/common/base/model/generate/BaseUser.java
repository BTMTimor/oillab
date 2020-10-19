package com.common.base.model.generate;

import com.jfinal.ext.common.model.BaseModel;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseUser<M extends BaseUser<M>> extends BaseModel<M> implements IBean {
	// 主键id
	public void setId(String id) {
		set("id", id);
	}

	// 主键id
	public String getId() {
		return getStr("id");
	}

	// 用户名
	public void setUsername(String username) {
		set("username", username);
	}

	// 用户名
	public String getUsername() {
		return getStr("username");
	}

	// 用户密码
	public void setPassword(String password) {
		set("password", password);
	}

	// 用户密码
	public String getPassword() {
		return getStr("password");
	}

	// 账户状态（0：未激活；1：启用；2：锁定；3：禁用）
	public void setStatus(Integer status) {
		set("status", status);
	}

	// 账户状态（0：未激活；1：启用；2：锁定；3：禁用）
	public Integer getStatus() {
		return get("status");
	}

}