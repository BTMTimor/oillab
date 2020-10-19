package com.jfinal.core;

import java.util.ArrayList;
import java.util.List;

/*
    author: Timor
    date: 2020/3/17 0017
*/
public class ApiModel {
    private String name;
    private String route;
    private List<ApiPara> parameters;
    private List<String> permission;
    private List<String> role;
    private String description;

    public ApiModel(String name, String route) {
        this(name, route, "");
    }

    public ApiModel(String name, String route, String description) {
        this.name = name;
        this.route = route;
        this.description = description;
        this.parameters = new ArrayList<>();
        this.permission = new ArrayList<>();
        this.role = new ArrayList<>();
    }

    public void addParas(ApiPara para){
        this.parameters.add(para);
    }

    public void addPermission(String permission){
        this.permission.add(permission);
    }

    public void addRole(String role){
        this.role.add(role);
    }


    public String getParaString(){
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        int counter = 0;
        for (ApiPara parameter : parameters) {
            String type = parameter.getType();
            type = type.substring(type.lastIndexOf(".") + 1);

            if (counter++ > 0){
                sb.append(", ");
            }
            sb.append(type).append(" ").append(parameter.getName());
        }
        sb.append(")");
        return sb.toString();
    }

    public String getPermissionString(){
        return list2String(permission);
    }

    public String getRoleString(){
        return list2String(role);
    }

    private String list2String(List<String> list){
        if (null == list || list.isEmpty()) return "";

        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for (String string : list){
            if(counter++ > 0){
                sb.append("、");
            }
            sb.append(string);
        }
        return sb.toString();
    }




    // generator getter and setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public List<ApiPara> getParameters() {
        return parameters;
    }

    public void setParameters(List<ApiPara> parameters) {
        this.parameters = parameters;
    }

    public List<String> getPermission() {
        return permission;
    }

    public void setPermission(List<String> permission) {
        this.permission = permission;
    }

    public List<String> getRole() {
        return role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
