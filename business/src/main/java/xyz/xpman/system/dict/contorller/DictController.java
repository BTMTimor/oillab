package xyz.xpman.system.dict.contorller;

import com.jfinal.aop.Inject;
import com.jfinal.core.paragetter.Para;
import com.jfinal.ext.annotation.RequestMapping;
import com.jfinal.ext.common.controller.BaseViewController;
import com.jfinal.ext.common.service.BaseService;
import xyz.xpman.system.dict.model.Dict;
import xyz.xpman.system.dict.model.DictCondition;
import xyz.xpman.system.dict.service.DictService;

/*
    author: Timor
    date: 2020/2/7 0007
*/
@RequestMapping(value = "/sys/dict", viewPath = "/view/backstage/sys/dict")
public class DictController extends BaseViewController<Dict> {
    @Inject private DictService service;

    @Override
    public void add() {
        super.add();
    }

    public void update(@Para("") DictCondition condition) {
        super.edit(condition);
    }

    public void list(@Para("") DictCondition condition) {
        setAttr("condition", condition);
        super.list();
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @Override
    protected BaseService<Dict> getService() {
        return service;
    }
}
