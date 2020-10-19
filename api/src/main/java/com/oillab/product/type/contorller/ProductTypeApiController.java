package com.oillab.product.type.contorller;

import com.jfinal.aop.Inject;
import com.jfinal.core.ActionKey;
import com.jfinal.core.paragetter.Para;
import com.jfinal.ext.annotation.RequestMapping;
import com.jfinal.ext.common.controller.BaseApiController;
import com.jfinal.ext.common.service.BaseService;
import com.oillab.product.type.model.ProductType;
import com.oillab.product.type.model.ProductTypeCondition;
import com.oillab.product.type.service.ProductTypeService;

/*
    author: Timor
    date: 2019/11/19 0019
*/
@RequestMapping(value = "/api/v1/product/type", viewPath = "/view/product/type")
public class ProductTypeApiController extends BaseApiController<ProductType> {
    @Inject private ProductTypeService service;

    @Override
    protected BaseService<ProductType> getService() {
        return service;
    }

    @ActionKey("/api/v1/product/type/get")
    public void getModular(String id){
        renderJson(findById(id));
    }

    public void add(@Para("") ProductType productType) {
        renderJson(checkAndAdd(productType));
    }

    public void update(@Para("") ProductType productType) {
        renderJson(checkAndUpdate(productType));
    }

    public void delete(String id) {
        renderJson(deleteById(id));
    }

    public void batchAdd() {
        renderJson(super.checkAndBatchAdd());
    }

    public void batchUpdate() {
        renderJson(super.checkAndBatchUpdate());
    }

    public void batchDelete() {
        renderJson(super.checkAndBatchDelete());
    }


    public void list(@Para("") ProductTypeCondition condition){
        renderJson(findAllByCondition(condition));
    }

    public void find(@Para("") ProductTypeCondition condition){
        renderJson(findPageByCondition(condition));
    }

    public void findOne(@Para("") ProductTypeCondition condition){
        renderJson(this.findOneByCondition(condition));
    }


}
