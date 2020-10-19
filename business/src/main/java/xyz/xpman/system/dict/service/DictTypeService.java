package xyz.xpman.system.dict.service;

import com.jfinal.ext.common.service.impl.BaseServiceImpl;
import xyz.xpman.system.dict.model.DictType;

/*
    author: Timor
    date: 2019/11/19 0019
*/
public class DictTypeService extends BaseServiceImpl<DictType> {
    public static final String SQL_NAMESPACE = "sys_dict_type";

    @Override
    public String getNamespace() {
        return SQL_NAMESPACE;
    }

}
