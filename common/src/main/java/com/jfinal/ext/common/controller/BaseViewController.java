package com.jfinal.ext.common.controller;

import com.jfinal.ext.common.model.BaseModel;
import com.jfinal.ext.common.model.ICondition;
import com.jfinal.ext.common.model.IFindCondition;
import com.jfinal.ext.common.service.BaseService;
import com.jfinal.ext.util.file.MyFileUtil;
import com.jfinal.kit.Kv;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Model;

import java.io.File;
import java.io.IOException;
import java.util.function.Supplier;

/*
    author: 江理网猿
    date: 2020/7/23 0023
*/
public abstract class BaseViewController<T extends BaseModel<T>>  extends BaseController<T> {
    protected static final String INDEX_PAGE = "index.html";
    protected static final String ADD_PAGE = "add.html";
    protected static final String VIEW_PAGE = "view.html";
    protected static final String PREVIEW_PAGE = "preview.html";
    protected static final String UPDATE_PAGE = "edit.html";
    protected static final String LIST_PAGE = "list.html";
    protected static final String TABLE_META_NAME = "tableMeta";

    public static final int idIndex = 0;
    public static final int pageNumberIndex = 1;
    public static final int pageSizeIndex = 2;

    public static final int defaultPageSize = 10;
    public static final int defaultPageNumber = 1;
    private static final String CONDITION_NAME = "condition";

    protected BaseService<T> getService(){
        throw new UnsupportedOperationException();
    }

    protected String getBaseViewPath(){return "";}
    protected int getDefaultPageNumber(){return defaultPageNumber;}
    protected int getDefaultPageSize(){return defaultPageSize;}


    protected void index(IFindCondition condition, String template){
        String id = (String) condition.getId();
        if(null == id && (null != (id = getPara(idIndex)))){
            condition.setId(id);
            condition.setPageSize(getInt(pageSizeIndex, getDefaultPageSize()));
            condition.setPageNumber(getInt(pageNumberIndex, getDefaultPageNumber()));
        }

        if(null != id){
            setAttr("entity", getService().findById(id));
            setAttr("condition", condition);
            render(template);
        }
    }


    protected boolean processEntityById(Object id){
        if(null != id){
            // 不为String或为String且非空
            if(id.getClass() != String.class || StrKit.notBlank((String) id)){
                T entity = getService().findById(id);
                if(null != entity){
                    setAttr("entity", entity);
                    return true;
                }
            }
        }
        return false;
    }


    protected void preview(Object id) {
        if(processEntityById(id)){
            render(getBaseViewPath() + PREVIEW_PAGE);
            return;
        }
        renderError(404);
    }

    protected void view(Object id) {
        if(processEntityById(id)){
            render(getBaseViewPath() + VIEW_PAGE);
            return;
        }
        renderError(404);
    }


    protected void add() {
        render(getBaseViewPath() + ADD_PAGE);
    }

    protected void add(ICondition condition) {
        setAttr(CONDITION_NAME, condition);
        add();
    }


    protected void copyToAdd(Object id){
        if(processEntityById(id)){
            render(getBaseViewPath() + ADD_PAGE);
            return;
        }
        renderError(404);
    }

    protected void copyToAdd(ICondition condition) {
        setAttr(CONDITION_NAME, condition);
        copyToAdd(condition.getId());
    }




    protected void edit(Object id) {
        if(processEntityById(id)){
            render(getBaseViewPath() + UPDATE_PAGE);
            return;
        }
        renderError(404);
    }

    protected void edit(ICondition condition) {
        setAttr(CONDITION_NAME, condition);
        edit(condition.getId());
    }



    protected void list() {
        tableMeta();
        render(getBaseViewPath() + LIST_PAGE);
    }

    protected void list(ICondition condition) {
        setAttr(CONDITION_NAME, condition);
        list();
    }



    // 返回model的元信息
    protected void tableMeta(){
        Kv tableMeta = getService().getTableMeta();
        setAttr(TABLE_META_NAME, tableMeta);
    }



    protected void renderTemplateOrStaticFile(String fileName, String template, Supplier<Model<?>> func) throws IOException {
        File file = new File(PathKit.getWebRootPath() + fileName);
        System.out.println(PathKit.getWebRootPath() + fileName);
        if(!file.exists()){
            Model<?> model = func.get();
            if(null == model){
                renderError(404);
                return;
            }

            String html = renderToString(template, model.toRecord().getColumns());
            MyFileUtil.writeStringToFile(html, file);
        }
        render(fileName);
    }

}
