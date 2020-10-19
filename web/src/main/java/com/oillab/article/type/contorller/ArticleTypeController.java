package com.oillab.article.type.contorller;

import com.jfinal.aop.Inject;
import com.jfinal.core.paragetter.Para;
import com.jfinal.ext.annotation.RequestMapping;
import com.jfinal.ext.common.controller.BaseViewController;
import com.jfinal.ext.common.service.BaseService;
import com.oillab.article.article.model.ArticleCondition;
import com.oillab.article.type.model.ArticleType;
import com.oillab.article.type.service.ArticleTypeService;

/*
    author: Timor
    date: 2020/2/7 0007
*/
@RequestMapping(value = "/article/type", viewPath = "/view/backstage/article/type")
public class ArticleTypeController extends BaseViewController<ArticleType> {
    @Inject private ArticleTypeService service;

    @Override
    protected BaseService<ArticleType> getService() {
        return service;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -


    public void add(@Para("") ArticleCondition condition) {
        super.add(condition);
    }

    public void update(@Para("") ArticleCondition condition) {
        super.edit(condition);
    }

    public void list(@Para("") ArticleCondition condition) {
        super.list(condition);
    }

}
