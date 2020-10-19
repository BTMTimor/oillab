package com.oillab.product.product.model;

import com.jfinal.ext.common.model.PageCondition;

/*
    author: 江理网猿
    date: 2020/7/21 0021
    description:
*/
public class ProductCondition extends PageCondition {
    private String id;
    private String name;
    private String category;
    private String type;
    private String model;
    private String coverImg;
    private String description;
    private String introduction;
    private String resource;
    private Integer status;

    @Override
    public String check() {
        return "";
    }

    // - - - - - - - - - - - - - auto generate- - - - - - - - - - - - -

    @Override
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
