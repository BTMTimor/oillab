package com.common.base.model.generate;

import com.jfinal.ext.common.model.BaseModel;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseService<M extends BaseService<M>> extends BaseModel<M> implements IBean {
	public void setId(Integer id) {
		set("id", id);
	}
	
	public Integer getId() {
		return getInt("id");
	}
	public void setName(String name) {
		set("name", name);
	}
	
	public String getName() {
		return getStr("name");
	}
	public void setUrl(String url) {
		set("url", url);
	}
	
	public String getUrl() {
		return getStr("url");
	}
	public void setDescribe(String describe) {
		set("describe", describe);
	}
	
	public String getDescribe() {
		return getStr("describe");
	}

}
