package com.oillab.article.article.controller;

import com.jfinal.aop.Inject;
import com.jfinal.core.ActionKey;
import com.jfinal.core.paragetter.Para;
import com.jfinal.ext.annotation.RequestMapping;
import com.jfinal.ext.common.api.result.ApiResult;
import com.jfinal.ext.common.controller.BaseApiController;
import com.jfinal.ext.common.service.BaseService;
import com.oillab.article.article.model.Article;
import com.oillab.article.article.model.ArticleCondition;
import com.oillab.article.article.service.ArticleService;

/*
    author: Timor
    date: 2019/11/19 0019
*/
@RequestMapping(value = "/api/v1/article")
public class ArticleApiController extends BaseApiController<Article> {
    @Inject private ArticleService service;

    @Override
    protected BaseService<Article> getService() {
        return service;
    }


    public void news(@Para("") ArticleCondition condition){
        condition.setTypeName("news");
        condition.setStatus(1);
        ApiResult result = findPageByCondition(condition);
        result.addData("url", "/article/news?1=1");
        renderJson(result);
    }


    @ActionKey("/api/v1/article/get")
    public void findById(int id) {
        renderJson(super.findById(id));
    }

    public void add(@Para("") Article article) {
        article.setUid(getUserId());
        renderJson(checkAndAdd(article));
    }

    public void update(@Para("") Article article) {
        article.setUid(getUserId());
        renderJson(checkAndUpdate(article));
    }

    // 用户：假删除
    public void delete(int id) {
        renderJson(fakeDelete(id, (article)->{
            article.setStatus(Article.Status.DELETE.getStatus());
        }));
    }

    // 管理员：真删除
    public void realDelete(int id) {
        renderJson(deleteById(id));
    }


    // 批量操作
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public void batchAdd() {
        renderJson(super.checkAndBatchAdd());
    }

    public void batchUpdate() {
        renderJson(super.checkAndBatchUpdate());
    }

    public void batchDelete() {
        renderJson(super.checkAndBatchDelete());
    }


    // 查询
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public void list(@Para("") ArticleCondition condition){
        renderJson(findAllByCondition(condition));
    }

    public void find(@Para("") ArticleCondition condition){
        renderJson(findPageByCondition(condition));
    }

    public void findOne(@Para("") ArticleCondition condition){
        renderJson(this.findOneByCondition(condition));
    }

}
