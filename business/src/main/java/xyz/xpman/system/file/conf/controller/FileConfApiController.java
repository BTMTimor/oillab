package xyz.xpman.system.file.conf.controller;

import com.jfinal.aop.Inject;
import com.jfinal.core.ActionKey;
import com.jfinal.core.paragetter.Para;
import com.jfinal.ext.annotation.RequestMapping;
import com.jfinal.ext.common.controller.BaseApiController;
import com.jfinal.ext.common.model.PageCondition;
import com.jfinal.ext.common.service.BaseService;
import xyz.xpman.system.file.conf.model.FileConf;
import xyz.xpman.system.file.conf.service.FileConfService;


@SuppressWarnings("unused")
@RequestMapping("/api/v1/file/conf")
public class FileConfApiController extends BaseApiController<FileConf> {
    @Inject private FileConfService fileConfService;

    @Override
    protected BaseService<FileConf> getService() { return fileConfService;}


    // - - - - - 增删改查 - - - - - - - - - - - - - - - - -

    @ActionKey("/api/v1/file/conf/get")
    public void findById(String id){
        renderJson(super.findById(id));
    }

    public void add(@Para("") FileConf fileConf) {
        renderJson(checkAndAdd(fileConf));
    }

    public void update(@Para("") FileConf fileConf) {
        renderJson(checkAndUpdate(fileConf));
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