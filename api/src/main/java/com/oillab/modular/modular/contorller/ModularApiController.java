package com.oillab.modular.modular.contorller;

import com.jfinal.aop.Inject;
import com.jfinal.core.ActionKey;
import com.jfinal.core.paragetter.Para;
import com.jfinal.ext.annotation.RequestMapping;
import com.jfinal.ext.common.controller.BaseApiController;
import com.oillab.article.article.service.ArticleService;
import com.oillab.modular.modular.model.Modular;
import com.oillab.modular.modular.model.ModularCondition;
import com.oillab.modular.modular.service.IModularService;
import com.oillab.modular.modular.service.ModularService;

/*
    author: Timor
    date: 2019/11/19 0019
*/
@RequestMapping(value = "/api/v1/modular")
public class ModularApiController extends BaseApiController<Modular> {
    @Inject private ModularService service;
    @Inject private ArticleService articleService;

    @Override
    protected IModularService getService() {
        return service;
    }

    public void indexContent(){
        ModularCondition condition = new ModularCondition();
        condition.setTypeName(ModularCondition.TYPE_INDEX_CONTENT);
        condition.setStatus(1);
        this.list(condition);
    }

    public void nav(){
        ModularCondition condition = new ModularCondition();
        condition.setTypeName(ModularCondition.TYPE_NAV);
        condition.setStatus(1);
        this.list(condition);
    }

    public void about(){
        ModularCondition condition = new ModularCondition();
        condition.setTypeName(ModularCondition.TYPE_ABOUT_CONTENT);
        condition.setStatus(1);
        this.list(condition);
    }

    public void articles(){
        forwardAction("/article/list");
    }


    // - - - - -  -

    @ActionKey("/api/v1/modular/get")
    public void getModular(int id){
        renderJson(findById(id));
    }

    public void add(@Para("") Modular modular) {
        renderJson(checkAndAdd(modular));
    }

    public void update(@Para("") Modular modular) {
        renderJson(checkAndUpdate(modular));
    }

    public void delete(int id) {
        renderJson(deleteById(id));
    }


    // 查询
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public void list(@Para("") ModularCondition condition){
        renderJson(super.findAllByCondition(condition));
    }

    public void find(@Para("") ModularCondition condition){
        renderJson(super.findPageByCondition(condition));
    }

    public void findOne(@Para("") ModularCondition condition){
        renderJson(super.findOneByCondition(condition));
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


}
