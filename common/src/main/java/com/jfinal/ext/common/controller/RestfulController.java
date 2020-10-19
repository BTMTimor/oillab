package com.jfinal.ext.common.controller;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.core.paragetter.Para;

/*
    author: Timor
    date: 2019/12/4 0004
*/
public abstract class RestfulController<T> extends Controller {

    public abstract void index();

    @ActionKey("get")
    public abstract void gets(int id);

    public abstract void add(@Para("") T model);

    public abstract void update(@Para("") T model);

    public abstract void delete(int id);

    public abstract void list(int pageNumber, int pageSize);
}
