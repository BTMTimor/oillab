package com.oillab.product.type.service;

import com.jfinal.ext.common.service.impl.BaseServiceImpl;
import com.oillab.product.type.model.ProductType;

/*
    author: Timor
    date: 2019/11/19 0019
*/
public class ProductTypeService extends BaseServiceImpl<ProductType> {
    public static final String SQL_NAMESPACE = "product_type";

    @Override
    public String getNamespace() {
        return SQL_NAMESPACE;
    }
}
