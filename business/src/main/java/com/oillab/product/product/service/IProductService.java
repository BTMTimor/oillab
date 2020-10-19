package com.oillab.product.product.service;

import com.jfinal.core.paragetter.Para;
import com.jfinal.ext.common.service.BaseService;
import com.jfinal.plugin.activerecord.Page;
import com.oillab.product.product.model.Product;
import com.oillab.product.product.model.ProductCondition;

/*
    author: Timor
    date: 2019/11/19 0019
*/
public interface IProductService extends BaseService<Product> {

   Page<Product> findHotProduct(@Para("") ProductCondition condition);
}