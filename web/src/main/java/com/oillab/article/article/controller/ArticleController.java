package com.oillab.article.article.controller;

import com.jfinal.aop.Clear;
import com.jfinal.aop.Inject;
import com.jfinal.core.paragetter.Para;
import com.jfinal.ext.annotation.RequestMapping;
import com.jfinal.ext.common.controller.BaseViewController;
import com.jfinal.ext.common.service.BaseService;
import com.jfinal.ext.interceptor.PermissionInterceptor;
import com.jfinal.kit.StrKit;
import com.oillab.article.article.model.Article;
import com.oillab.article.article.model.ArticleCondition;
import com.oillab.article.article.service.ArticleService;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
    author: Timor
    date: 2020/2/7 0007
*/
@RequestMapping(value = "/article", viewPath = "/view/backstage/article")
public class ArticleController extends BaseViewController<Article> {
    private static final SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Inject private ArticleService service;

    @Clear(PermissionInterceptor.class)
    public void index(){
        String id = get(0);
        if(StrKit.notBlank(id)){
            Article article = service.findById(id);
            if(null != article){
                setAttr("entity", article);
                render("/view/default/temp/article/article.html");
            }
        }
    }
    
    public void add(@Para("") ArticleCondition condition) {
        setAttr("now", dataFormat.format(new Date()));
        super.add(condition);
    }

    public void update(@Para("") ArticleCondition condition) {
        setAttr("now", dataFormat.format(new Date()));
        super.edit(condition);
    }

    public void list(@Para("") ArticleCondition condition) {
        super.list(condition);
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @Override
    protected BaseService<Article> getService() {
        return service;
    }
}
