package com.oillab.article.type.service;

import com.jfinal.ext.common.service.impl.BaseServiceImpl;
import com.oillab.article.type.model.ArticleType;

/*
    author: Timor
    date: 2019/11/19 0019
*/
public class ArticleTypeService extends BaseServiceImpl<ArticleType> {
    public static final String SQL_NAMESPACE = "article_type";

    @Override
    public String getNamespace() {
        return SQL_NAMESPACE;
    }
}
