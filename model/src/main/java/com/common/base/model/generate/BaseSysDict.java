package com.common.base.model.generate;

import com.jfinal.ext.common.model.BaseModel;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseSysDict<M extends BaseSysDict<M>> extends BaseModel<M> implements IBean {
	// 字典id
	public void setId(String id) {
		set("id", id);
	}

	// 字典id
	public String getId() {
		return getStr("id");
	}

	// 字典类型
	public void setType(String type) {
		set("type", type);
	}

	// 字典类型
	public String getType() {
		return getStr("type");
	}

	// 额外的：字典类型
	public String getTypeName() {
		return getStr("type");
	}

	// 字典名
	public void setName(String name) {
		set("name", name);
	}

	// 字典名
	public String getName() {
		return getStr("name");
	}

	// 字典值
	public void setValue(String value) {
		set("value", value);
	}

	// 字典值
	public String getValue() {
		return getStr("value");
	}

	// 描述
	public void setDescription(String description) {
		set("description", description);
	}

	// 描述
	public String getDescription() {
		return getStr("description");
	}

	// 类型是否可改变（0：可变；1：不可变）
	public void setFixed(Integer fixed) {
		set("fixed", fixed);
	}

	// 排序序号
	public Integer getSort() {
		return getInt("sort");
	}

	public void setSort(Integer fixed) {
		set("sort", fixed);
	}

	// 类型是否可改变（0：可变；1：不可变）
	public Integer getFixed() {
		return getInt("fixed");
	}

}
