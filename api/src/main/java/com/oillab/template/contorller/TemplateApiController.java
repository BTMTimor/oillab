package com.oillab.template.contorller;

import com.jfinal.aop.Inject;
import com.jfinal.core.ActionKey;
import com.jfinal.core.paragetter.Para;
import com.jfinal.ext.annotation.RequestMapping;
import com.jfinal.ext.common.controller.BaseApiController;
import com.jfinal.ext.common.service.BaseService;
import com.oillab.template.model.Template;
import com.oillab.template.model.TemplateCondition;
import com.oillab.template.service.TemplateService;

/*
    author: Timor
    date: 2019/11/19 0019
*/
@RequestMapping("/api/v1/template")
public class TemplateApiController extends BaseApiController<Template> {
    @Inject private TemplateService service;

    @Override
    protected BaseService<Template> getService() {
        return service;
    }

    public void index(){
        forwardAction("/");
    }

    @ActionKey("/api/v1/view/get")
    public void getTemplate(int id){
        renderJson(findById(id));
    }

    public void add(@Para("") Template modular) {
        renderJson(checkAndAdd(modular));
    }

    public void update(@Para("") Template modular) {
        renderJson(checkAndUpdate(modular));
    }

    public void delete(int id) {
        renderJson(deleteById(id));
    }

    public void list(@Para("") TemplateCondition condition){
        renderJson(super.findAllByCondition(condition));
    }

    public void find(@Para("") TemplateCondition condition){
        renderJson(super.findPageByCondition(condition));
    }

    public void findOne(@Para("") TemplateCondition condition){
        renderJson(super.findOneByCondition(condition));
    }

}
