package com.oillab.product.category.contorller;

import com.jfinal.aop.Inject;
import com.jfinal.core.paragetter.Para;
import com.jfinal.ext.annotation.RequestMapping;
import com.jfinal.ext.common.controller.BaseViewController;
import com.jfinal.ext.common.service.BaseService;
import com.oillab.product.category.model.ProductCategory;
import com.oillab.product.category.model.ProductCategoryCondition;
import com.oillab.product.category.service.ProductCategoryService;

/*
    author: Timor
    date: 2020/2/7 0007
*/
@RequestMapping(value = "/product/category", viewPath = "/view/backstage/product/category")
public class ProductCategoryController extends BaseViewController<ProductCategory> {
    @Inject private ProductCategoryService service;

    public void add(@Para("") ProductCategoryCondition condition) {
        super.add(condition);
    }

    public void update(@Para("") ProductCategoryCondition condition) {
        super.edit(condition);
    }

    public void list(@Para("") ProductCategoryCondition condition) {
        super.list(condition);
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @Override
    protected BaseService<ProductCategory> getService() {
        return service;
    }
}
