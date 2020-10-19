package com.oillab.product.category.contorller;

import com.jfinal.aop.Inject;
import com.jfinal.core.ActionKey;
import com.jfinal.core.paragetter.Para;
import com.jfinal.ext.annotation.RequestMapping;
import com.jfinal.ext.common.controller.BaseApiController;
import com.jfinal.ext.common.service.BaseService;
import com.oillab.product.category.model.ProductCategory;
import com.oillab.product.category.model.ProductCategoryCondition;
import com.oillab.product.category.service.ProductCategoryService;

/*
    author: Timor
    date: 2019/11/19 0019
*/
@RequestMapping("/api/v1/product/category")
public class ProductApiCategoryController extends BaseApiController<ProductCategory> {
    @Inject private ProductCategoryService service;

    @Override
    protected BaseService<ProductCategory> getService() {
        return service;
    }

    @ActionKey("/api/v1/product/category/get")
    public void findById(String id){
        renderJson(super.findById(id));
    }

    public void add(@Para("") ProductCategory productCategory) {
        renderJson(checkAndAdd(productCategory));
    }

    public void update(@Para("") ProductCategory productCategory) {
        renderJson(checkAndUpdate(productCategory));
    }

    public void delete(String id) {
        renderJson(deleteById(id));
    }

    public void list(@Para("") ProductCategoryCondition condition){
        renderJson(super.findAllByCondition(condition));
    }

    public void find(@Para("") ProductCategoryCondition condition){
        renderJson(super.findPageByCondition(condition));
    }

    public void findOne(@Para("") ProductCategoryCondition condition){
        renderJson(super.findOneByCondition(condition));
    }

    public void batchDelete(){
        renderJson(super.checkAndBatchDelete());
    }
}
