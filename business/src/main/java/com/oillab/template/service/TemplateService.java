package com.oillab.template.service;

import com.jfinal.ext.common.service.impl.BaseServiceImpl;
import com.oillab.template.model.Template;

/*
    author: Timor
    date: 2019/11/19 0019
*/
public class TemplateService extends BaseServiceImpl<Template> {
    public static final String SQL_NAMESPACE = "template";

    @Override
    public String getNamespace() {
        return SQL_NAMESPACE;
    }

}
