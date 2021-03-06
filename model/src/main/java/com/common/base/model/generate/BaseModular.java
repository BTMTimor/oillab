package com.common.base.model.generate;

import com.jfinal.ext.common.model.BaseModel;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseModular<M extends BaseModular<M>> extends BaseModel<M> implements IBean {
	// 主键id
	public void setId(Integer id) {
		set("id", id);
	}

	// 主键id
	public Integer getId() {
		return getInt("id");
	}

	// 模块类型（1：导航模块、2：页面模块、3：页面内容模块）
	public void setType(String type) {
		set("type", type);
	}

	// 模块类型（1：导航模块、2：页面模块、3：页面内容模块）
	public String getType() {
		return getStr("type");
	}

	// 模块名（作为id或class等用）
	public void setName(String name) {
		set("name", name);
	}

	// 模块名（作为id或class等用）
	public String getName() {
		return getStr("name");
	}

	// 模块标题
	public void setTitle(String title) {
		set("title", title);
	}

	// 模块标题
	public String getTitle() {
		return getStr("title");
	}

	// 模块英文标题（部分内容/国际化需要）
	public void setEnglishTitle(String englishTitle) {
		set("englishTitle", englishTitle);
	}

	// 模块英文标题（部分内容/国际化需要）
	public String getEnglishTitle() {
		return getStr("englishTitle");
	}

	// 模块对应页面地址
	public void setUrl(String url) {
		set("url", url);
	}

	// 模块对应页面地址
	public String getUrl() {
		return getStr("url");
	}

	// 页面渲染需要的配置来源url
	public void setConfig(String config) {
		set("config", config);
	}

	// 页面渲染需要的配置来源url
	public String getConfig() {
		return getStr("config");
	}

	// 排序值；
	public void setSort(Integer sort) {
		set("sort", sort);
	}

	// 排序值；
	public Integer getSort() {
		return getInt("sort");
	}

	// 状态：禁用：-1；测试：0；启用：1；
	public void setStatus(Integer status) {
		set("status", status);
	}

	// 状态：禁用：-1；测试：0；启用：1；
	public Integer getStatus() {
		return getInt("status");
	}

}
