package com.oillab.modular.type.contorller;

import com.jfinal.aop.Inject;
import com.jfinal.core.paragetter.Para;
import com.jfinal.ext.annotation.RequestMapping;
import com.jfinal.ext.common.controller.BaseViewController;
import com.jfinal.ext.common.service.BaseService;
import com.oillab.article.article.model.ArticleCondition;
import com.oillab.modular.type.model.ModularType;
import com.oillab.modular.type.service.ModularTypeService;

/*
    author: Timor
    date: 2020/2/7 0007
*/
@RequestMapping(value = "/modular/type", viewPath = "/view/backstage/modular/type")
public class ModularTypeController extends BaseViewController<ModularType> {
    @Inject private ModularTypeService service;

    @Override
    protected BaseService<ModularType> getService() {
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
