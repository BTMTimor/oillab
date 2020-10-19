package com.oillab.product.category.service;

import com.jfinal.ext.common.service.impl.BaseServiceImpl;
import com.oillab.product.category.model.ProductCategory;

/*
    author: Timor
    date: 2019/11/19 0019
*/
public class ProductCategoryService extends BaseServiceImpl<ProductCategory> {
    public static final String SQL_NAMESPACE = "product_category";

    @Override
    public String getNamespace() {
        return SQL_NAMESPACE;
    }
}
