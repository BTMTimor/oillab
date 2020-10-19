package xyz.xpman.system.dict.contorller;

import com.jfinal.aop.Inject;
import com.jfinal.core.ActionKey;
import com.jfinal.core.paragetter.Para;
import com.jfinal.ext.annotation.RequestMapping;
import com.jfinal.ext.common.controller.BaseApiController;
import com.jfinal.ext.common.service.BaseService;
import xyz.xpman.system.dict.model.DictType;
import xyz.xpman.system.dict.model.DictTypeCondition;
import xyz.xpman.system.dict.service.DictTypeService;

/*
    author: Timor
    date: 2019/11/19 0019
*/
@RequestMapping(value = "/api/v1/sys/dict/type")
public class DictTypeApiController extends BaseApiController<DictType> {
    @Inject private DictTypeService service;

    
    @Override
    protected BaseService<DictType> getService() {
        return service;
    }

    public void index(){
        forwardAction("/");
    }

    @ActionKey("/api/v1/sys/dict/type/get")
    public void getById(String id){
        renderJson(findById(id));
    }

    public void add(@Para("") DictType dict) {
        renderJson(checkAndAdd(dict));
    }

    public void update(@Para("") DictType dict) {
        renderJson(checkAndUpdate(dict));
    }

    public void delete(String id) {
        renderJson(deleteById(id));
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

    public void list(@Para("") DictTypeCondition condition){
        renderJson(super.findAllByCondition(condition));
    }

    public void find(@Para("") DictTypeCondition condition){
        renderJson(super.findPageByCondition(condition));
    }

    public void findOne(@Para("") DictTypeCondition condition){
        renderJson(super.findOneByCondition(condition));
    }

}
