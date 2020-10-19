package com.jfinal.ext.common.model;

/*
    author: Timor
    date: 2020/7/14 0014
*/
public class FindCondition extends PageCondition implements IFindCondition{
    public static final String SORT_DESC = "desc";
    public static final String SORT_ASC = "asc";
    private String sort; // 排序的列
    private String sortOrder; // 排序命令（desc，asc）

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

}
