package xyz.xpman.system.dict.contorller;

import com.jfinal.aop.Inject;
import com.jfinal.core.paragetter.Para;
import com.jfinal.ext.annotation.RequestMapping;
import com.jfinal.ext.common.controller.BaseViewController;
import com.jfinal.ext.common.service.BaseService;
import xyz.xpman.system.dict.model.DictType;
import xyz.xpman.system.dict.model.DictTypeCondition;
import xyz.xpman.system.dict.service.DictTypeService;

/*
    author: Timor
    date: 2020/2/7 0007
*/
@RequestMapping(value = "/sys/dict/type", viewPath = "/view/backstage/sys/dict/type")
public class DictTypeController extends BaseViewController<DictType> {
    @Inject private DictTypeService service;

    @Override
    public void add() {
        super.add();
    }

    public void update(@Para("") DictTypeCondition condition) {
        super.edit(condition);
    }

    @Override
    public void list() {
        super.list();
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @Override
    protected BaseService<DictType> getService() {
        return service;
    }
}
