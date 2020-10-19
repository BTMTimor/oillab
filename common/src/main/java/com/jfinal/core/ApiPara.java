package com.jfinal.core;


/*
    author: Timor
    date: 2020/3/17 0017
*/
public class ApiPara {
    private String name;
    private String type;
    private String description;

    public ApiPara() {}

    public ApiPara(String name, String type) {
        this(name, type, "");
    }

    public ApiPara(String name, String type, String description) {
        this.name = name;
        this.type = type;
        this.description = description;
    }


    // generator getter and setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
