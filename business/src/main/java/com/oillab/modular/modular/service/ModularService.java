package com.oillab.modular.modular.service;

import com.jfinal.ext.common.service.impl.BaseServiceImpl;
import com.oillab.modular.modular.model.Modular;

/*
    author: Timor
    date: 2019/11/19 0019
*/
public class ModularService extends BaseServiceImpl<Modular> implements IModularService{
    public static final String SQL_NAMESPACE = "modular";

    @Override
    public String getNamespace() {
        return SQL_NAMESPACE;
    }
}
