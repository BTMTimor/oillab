package com.oillab.product.type.contorller;

import com.jfinal.aop.Inject;
import com.jfinal.core.paragetter.Para;
import com.jfinal.ext.annotation.RequestMapping;
import com.jfinal.ext.common.controller.BaseViewController;
import com.jfinal.ext.common.service.BaseService;
import com.oillab.product.type.model.ProductType;
import com.oillab.product.type.model.ProductTypeCondition;
import com.oillab.product.type.service.ProductTypeService;

/*
    author: Timor
    date: 2020/2/7 0007
*/
@RequestMapping(value = "/product/type", viewPath = "/view/backstage/product/type")
public class ProductTypeController extends BaseViewController<ProductType> {
    @Inject private ProductTypeService service;

    @Override
    protected BaseService<ProductType> getService() {
        return service;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -


    public void add(@Para("") ProductTypeCondition condition) {
        super.add(condition);
    }

    public void update(@Para("") ProductTypeCondition condition) {
        super.edit(condition);
    }

    public void list(@Para("") ProductTypeCondition condition) {
        super.list(condition);
    }


}
