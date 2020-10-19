package com.jfinal.ext.util;

import com.jfinal.core.Action;
import com.jfinal.core.Controller;
import com.jfinal.core.paragetter.ParaGetter;

/*
    author: 江理网猿
    date: 2020/7/22 0022
*/
public class JSONParaGetter extends ParaGetter {
    public JSONParaGetter(String parameterName, String defaultValue) {
        super(parameterName, defaultValue);
    }

    @Override
    protected Object to(String s) {
        return null;
    }

    @Override
    public Object get(Action action, Controller controller) {
        return null;
    }
}
