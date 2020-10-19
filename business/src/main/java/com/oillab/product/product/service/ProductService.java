package com.oillab.product.product.service;

import com.jfinal.core.paragetter.Para;
import com.jfinal.ext.common.service.impl.BaseServiceImpl;
import com.jfinal.plugin.activerecord.Page;
import com.oillab.product.product.model.Product;
import com.oillab.product.product.model.ProductCondition;

/*
    author: Timor
    date: 2019/11/19 0019
*/
public class ProductService extends BaseServiceImpl<Product> implements IProductService {
    private static final String SQL_NAMESPACE = "product";

    @Override
    public String getNamespace() {
        return SQL_NAMESPACE;
    }

    public Page<Product> findHotProduct(@Para("") ProductCondition condition) {
        return findPageByCondition(condition);
    }
}