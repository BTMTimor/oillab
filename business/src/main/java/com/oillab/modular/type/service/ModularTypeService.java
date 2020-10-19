package com.oillab.modular.type.service;

import com.jfinal.ext.common.service.impl.BaseServiceImpl;
import com.oillab.modular.type.model.ModularType;

/*
    author: Timor
    date: 2019/11/19 0019
*/
public class ModularTypeService extends BaseServiceImpl<ModularType> {
    public static final String SQL_NAMESPACE = "modular_type";

    @Override
    public String getNamespace() {
        return SQL_NAMESPACE;
    }
}
