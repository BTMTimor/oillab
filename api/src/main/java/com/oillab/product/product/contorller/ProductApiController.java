package com.oillab.product.product.contorller;

import com.jfinal.aop.Inject;
import com.jfinal.core.ActionKey;
import com.jfinal.core.paragetter.Para;
import com.jfinal.ext.annotation.RequestMapping;
import com.jfinal.ext.common.api.result.ApiResult;
import com.jfinal.ext.common.controller.BaseApiController;
import com.jfinal.plugin.activerecord.Page;
import com.oillab.product.product.model.Product;
import com.oillab.product.product.model.ProductCondition;
import com.oillab.product.product.service.IProductService;
import com.oillab.product.product.service.ProductService;

/*
    author: Timor
    date: 2019/11/19 0019
*/
@RequestMapping(value = "/api/v1/product", viewPath = "/view/product")
public class ProductApiController extends BaseApiController<Product> {
    @Inject(ProductService.class) private IProductService service;

    @Override
    protected IProductService getService() {
        return service;
    }

    @ActionKey("/api/v1/product/get")
    public void findById(String id){
        ProductCondition condition = new ProductCondition();
        condition.setId(id);
        renderJson(super.findOneByCondition(condition));
    }

    public void add(@Para("") Product product) {
        renderJson(checkAndAdd(product));
    }

    public void update(@Para("") Product product) {
        renderJson(checkAndUpdate(product));
    }

    public void delete(String id) {
        renderJson(deleteById(id));
    }


    public void hot(@Para("") ProductCondition condition){
        condition.setStatus(1);
        Page<Product> hotProduct = getService().findHotProduct(condition);
        renderJson(ApiResult.success(hotProduct));
    }


    public void list(@Para("") ProductCondition condition){
        renderJson(super.findAllByCondition(condition));
    }

    public void find(@Para("") ProductCondition condition){
        renderJson(super.findPageByCondition(condition));
    }

    public void findOne(@Para("") ProductCondition condition){
        renderJson(super.findOneByCondition(condition));
    }


    public void batchDelete(){
        renderJson(super.checkAndBatchDelete());
    }
}
