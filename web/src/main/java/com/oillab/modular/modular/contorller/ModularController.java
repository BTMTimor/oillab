package com.oillab.modular.modular.contorller;

import com.jfinal.aop.Inject;
import com.jfinal.core.paragetter.Para;
import com.jfinal.ext.annotation.RequestMapping;
import com.jfinal.ext.common.controller.BaseViewController;
import com.jfinal.ext.common.service.BaseService;
import com.oillab.modular.modular.model.Modular;
import com.oillab.modular.modular.model.ModularCondition;
import com.oillab.modular.modular.service.ModularService;

/*
    author: Timor
    date: 2020/2/7 0007
*/
@RequestMapping(value = "/modular", viewPath = "/view/backstage/modular")
public class ModularController extends BaseViewController<Modular> {
    @Inject private ModularService service;
    
    public void add(@Para("") ModularCondition condition) {
        super.add(condition);
    }

    public void update(@Para("") ModularCondition condition) {
        super.edit(condition);
    }

    public void list(@Para("") ModularCondition condition) {
        super.list(condition);
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @Override
    protected BaseService<Modular> getService() {
        return service;
    }
}
