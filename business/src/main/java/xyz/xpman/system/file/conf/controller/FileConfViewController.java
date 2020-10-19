package xyz.xpman.system.file.conf.controller;

import com.jfinal.aop.Inject;
import com.jfinal.ext.annotation.RequestMapping;
import com.jfinal.ext.common.controller.BaseViewController;
import com.jfinal.ext.common.service.BaseService;
import xyz.xpman.system.file.conf.model.FileConf;
import xyz.xpman.system.file.conf.service.FileConfService;

/**
 * author: Timor
 * date: 2020-9-10
 * description: ……
 */
@SuppressWarnings("unused")
@RequestMapping(value = "/file/conf", viewPath = "")
public class FileConfViewController extends BaseViewController<FileConf> {
    @Inject private FileConfService fileConfService;

    @Override
    protected BaseService<FileConf> getService() {
        return fileConfService;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -


    @Override
    public void add() {
        super.add();
    }

    public void update(String id) {
        super.edit(id);
    }

    @Override
    public void list() {
        super.list();
    }

}