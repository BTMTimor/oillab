package com.oillab.modular.type.model;

import com.jfinal.ext.common.model.FindCondition;

/*
    author: 江理网猿
    date: 2020/7/21 0021
*/
public class ModularTypeCondition extends FindCondition {
    private String id;
    private String name;
    private String description;
    private Integer status;

    @Override
    public String check() {
        return "";
    }

    // - - - - - - - - - - - - - auto generate- - - - - - - - - - - - -

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
