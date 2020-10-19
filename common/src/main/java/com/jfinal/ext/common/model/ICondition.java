package com.jfinal.ext.common.model;

/*
    author: Timor
    date: 2020/7/14 0014
*/
public interface ICondition {
    String EMPTY_STRING = "";

    // 检查查询参数，如果没有问题则返回(EMPTY_STRING);
    String check();

    default Object getId(){
        throw new UnsupportedOperationException();
    }

}
