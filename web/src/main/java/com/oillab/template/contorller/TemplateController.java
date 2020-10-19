package com.oillab.template.contorller;

import com.jfinal.aop.Inject;
import com.jfinal.core.paragetter.Para;
import com.jfinal.ext.annotation.RequestMapping;
import com.jfinal.ext.common.controller.BaseViewController;
import com.jfinal.ext.common.service.BaseService;
import com.oillab.template.model.Template;
import com.oillab.template.model.TemplateCondition;
import com.oillab.template.service.TemplateService;

/*
    author: Timor
    date: 2020/2/7 0007
*/
@RequestMapping(value = "/template", viewPath = "/view/backstage/template")
public class TemplateController extends BaseViewController<Template> {
    @Inject private TemplateService service;

    @Override
    public void add() {
        super.add();
    }

    public void update(@Para("") TemplateCondition condition) {
        super.edit(condition);
    }

    @Override
    public void list() {
        super.list();
    }

    // 分页组件模板
    public void pagination() {
        render("/view/default/common/pagination2.htm");
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @Override
    protected BaseService<Template> getService() {
        return service;
    }
}
