package xyz.xpman.system.file.info.controller;

import com.jfinal.aop.Inject;
import com.jfinal.core.ActionKey;
import com.jfinal.core.paragetter.Para;
import com.jfinal.ext.annotation.RequestMapping;
import com.jfinal.ext.common.controller.BaseApiController;
import com.jfinal.ext.common.model.PageCondition;
import com.jfinal.ext.common.service.BaseService;
import xyz.xpman.system.file.info.model.FileInfo;
import xyz.xpman.system.file.info.service.FileInfoService;


@SuppressWarnings("unused")
@RequestMapping("/api/v1/file/info")
public class FileInfoApiController extends BaseApiController<FileInfo> {
    @Inject private FileInfoService fileInfoService;

    @Override
    protected BaseService<FileInfo> getService() { return fileInfoService;}


    // - - - - - 增删改查 - - - - - - - - - - - - - - - - -

    @ActionKey("/api/v1/file/info/get")
    public void findById(String id){
        renderJson(super.findById(id));
    }

    public void add(@Para("") FileInfo fileInfo) {
        renderJson(checkAndAdd(fileInfo));
    }

    public void update(@Para("") FileInfo fileInfo) {
        renderJson(checkAndUpdate(fileInfo));
    }

    public void delete(int id) {
        renderJson(deleteById(id));
    }


    // - - - - - 数据查找相关 - - - - - - - - - - - - - - - - -

    public void list(@Para("") PageCondition condition){
        renderJson(super.findAllByCondition(condition));
    }

    public void find(@Para("") PageCondition condition){
        renderJson(super.findPageByCondition(condition));
    }

    // TODO
    public void findOne(@Para("") PageCondition condition){
        renderJson(super.findOneByCondition(condition));
    }


    // - - - - - 批量操作 - - - - - - - - - - - - - - - - -

    public void batchAdd(){
        renderJson(super.checkAndBatchAdd());
    }

    public void batchUpdate(){
        renderJson(super.checkAndBatchUpdate());
    }

    public void batchDelete(){
        renderJson(super.checkAndBatchDelete());
    }

}