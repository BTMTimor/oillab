package xyz.xpman.system.file.info.controller;

import com.jfinal.aop.Inject;
import com.jfinal.ext.annotation.RequestMapping;
import com.jfinal.ext.common.controller.BaseViewController;
import com.jfinal.ext.common.service.BaseService;
import xyz.xpman.system.file.info.model.FileInfo;
import xyz.xpman.system.file.info.service.FileInfoService;

/**
 * author: Timor
 * date: 2020-9-10
 * description: ……
 */
@SuppressWarnings("unused")
@RequestMapping(value = "/file/info", viewPath = "")
public class FileInfoViewController extends BaseViewController<FileInfo> {
    @Inject private FileInfoService fileInfoService;

    @Override
    protected BaseService<FileInfo> getService() {
        return fileInfoService;
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