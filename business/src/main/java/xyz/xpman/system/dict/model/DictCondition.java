package xyz.xpman.system.dict.model;

import com.jfinal.ext.common.model.PageCondition;

/*
    author: 江理网猿
    date: 2020/7/21 0021
*/
public class DictCondition extends PageCondition {
    private Integer id;
    private String type;
    private String typeName;
    private String name;
    private String value;
    private String description;
    private Integer sort;
    private Integer status;

    @Override
    public String check() {
        return "";
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - -

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    // - - - -

    @Override
    public String toString() {
        return "DictCondition{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", typeName='" + typeName + '\'' +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", description='" + description + '\'' +
                ", sort=" + sort +
                ", status=" + status +
                '}';
    }
}
