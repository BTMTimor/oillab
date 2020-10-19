package com.oillab.article.article.service;

import com.jfinal.ext.common.service.impl.BaseServiceImpl;
import com.oillab.article.article.model.Article;

/*
    author: Timor
    date: 2019/11/19 0019
*/
public class ArticleService extends BaseServiceImpl<Article> {
    public static final String SQL_NAMESPACE = "article";

    @Override
    public String getNamespace() {
        return SQL_NAMESPACE;
    }

}
