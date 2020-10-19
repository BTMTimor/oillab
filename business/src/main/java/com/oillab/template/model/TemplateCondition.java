package com.oillab.template.model;

import com.jfinal.ext.common.model.PageCondition;

/*
    author: Timor
    date: 2020/7/14 0014
*/
public class TemplateCondition extends PageCondition {
    private Integer id = null;// id
    private String name = null;// 模板名称
    private String type = null;// 模板类型
    private Integer status = null;// 模板状态


    // - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
