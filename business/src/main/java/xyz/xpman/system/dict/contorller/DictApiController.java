package xyz.xpman.system.dict.contorller;

import com.jfinal.aop.Inject;
import com.jfinal.core.ActionKey;
import com.jfinal.core.paragetter.Para;
import com.jfinal.ext.annotation.RequestMapping;
import com.jfinal.ext.common.controller.BaseApiController;
import com.jfinal.ext.common.service.BaseService;
import xyz.xpman.system.dict.model.Dict;
import xyz.xpman.system.dict.model.DictCondition;
import xyz.xpman.system.dict.service.DictService;

/*
    author: Timor
    date: 2019/11/19 0019
*/
@RequestMapping(value = "/api/v1/sys/dict")
public class DictApiController extends BaseApiController<Dict> {
    @Inject private DictService service;

    @Override
    protected BaseService<Dict> getService() {
        return service;
    }

    public void index(){
        forwardAction("/");
    }

    @ActionKey("/api/v1/sys/dict/get")
    public void getById(int id){
        renderJson(findById(id));
    }

    public void add(@Para("") Dict dict) {
        renderJson(checkAndAdd(dict));
    }

    public void update(@Para("") Dict dict) {
        renderJson(checkAndUpdate(dict));
    }

    public void delete(int id) {
        renderJson(deleteById(id));
    }

    public void list(@Para("") DictCondition condition){
        renderJson(super.findAllByCondition(condition));
    }

    public void find(@Para("") DictCondition condition){
        renderJson(super.findPageByCondition(condition));
    }

    public void findOne(@Para("") DictCondition condition){
        renderJson(super.findOneByCondition(condition));
    }

}
