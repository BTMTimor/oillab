package com.oillab.modular.modular.model;

import com.jfinal.ext.common.model.PageCondition;

/*
    author: 江理网猿
    date: 2020/7/21 0021
*/
public class ModularCondition extends PageCondition {
    public static final String TYPE_NAV = "nav";
    public static final String TYPE_INDEX_CONTENT = "index_content";
    public static final String TYPE_ABOUT_CONTENT = "about_content";

    private Integer id;
    private Integer type;
    private String typeName;
    private String name;
    private String title;
    private String englishTitle;
    private String url;
    private String config;
    private Integer status;

    @Override
    public String check() {
        return "";
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - -

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getEnglishTitle() {
        return englishTitle;
    }

    public void setEnglishTitle(String englishTitle) {
        this.englishTitle = englishTitle;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    @Override
    public String toString() {
        return "ModularCondition{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", typeName='" + typeName + '\'' +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", englishTitle='" + englishTitle + '\'' +
                ", url='" + url + '\'' +
                ", config='" + config + '\'' +
                ", status=" + status +
                '}';
    }
}
