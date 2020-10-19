package com.oillab.article.type.contorller;

import com.jfinal.aop.Inject;
import com.jfinal.core.ActionKey;
import com.jfinal.core.paragetter.Para;
import com.jfinal.ext.annotation.RequestMapping;
import com.jfinal.ext.common.controller.BaseApiController;
import com.jfinal.ext.common.service.BaseService;
import com.oillab.article.type.model.ArticleType;
import com.oillab.article.type.model.ArticleTypeCondition;
import com.oillab.article.type.service.ArticleTypeService;

/*
    author: Timor
    date: 2019/11/19 0019
*/
@RequestMapping(value = "/api/v1/article/type")
public class ArticleTypeApiController extends BaseApiController<ArticleType> {
    @Inject private ArticleTypeService service;

    @Override
    protected BaseService<ArticleType> getService() {
        return service;
    }

    @ActionKey("/api/v1/article/type/get")
    public void findById(String id){
        renderJson(super.findById(id));
    }

    public void add(@Para("") ArticleType articleType) {
        renderJson(super.checkAndAdd(articleType));
    }

    public void update(@Para("") ArticleType articleType) {
        renderJson(super.checkAndUpdate(articleType));
    }

    public void delete(String id) {
        renderJson(super.deleteById(id));
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


    public void list(@Para("") ArticleTypeCondition condition){
        renderJson(super.findAllByCondition(condition));
    }

    public void find(@Para("") ArticleTypeCondition condition){
        renderJson(super.findPageByCondition(condition));
    }

    public void findOne(@Para("") ArticleTypeCondition condition){
        renderJson(super.findOneByCondition(condition));
    }


}
