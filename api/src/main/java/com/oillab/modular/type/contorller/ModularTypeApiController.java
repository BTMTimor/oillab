package com.oillab.modular.type.contorller;

import com.jfinal.aop.Inject;
import com.jfinal.core.ActionKey;
import com.jfinal.core.paragetter.Para;
import com.jfinal.ext.annotation.RequestMapping;
import com.jfinal.ext.common.controller.BaseApiController;
import com.jfinal.ext.common.service.BaseService;
import com.oillab.modular.type.model.ModularType;
import com.oillab.modular.type.model.ModularTypeCondition;
import com.oillab.modular.type.service.ModularTypeService;

/*
    author: Timor
    date: 2019/11/19 0019
*/
@RequestMapping(value = "/api/v1/modular/type")
public class ModularTypeApiController extends BaseApiController<ModularType> {
    @Inject private ModularTypeService service;

    @Override
    protected BaseService<ModularType> getService() {
        return service;
    }

    @ActionKey("/api/v1/modular/type/get")
    public void findById(String id){
        renderJson(super.findById(id));
    }

    public void add(@Para("") ModularType modularType) {
        renderJson(super.checkAndAdd(modularType));
    }

    public void update(@Para("") ModularType modularType) {
        renderJson(super.checkAndUpdate(modularType));
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


    public void list(@Para("") ModularTypeCondition condition){
        renderJson(super.findAllByCondition(condition));
    }

    public void find(@Para("") ModularTypeCondition condition){
        renderJson(super.findPageByCondition(condition));
    }

    public void findOne(@Para("") ModularTypeCondition condition){
        renderJson(super.findOneByCondition(condition));
    }


}
