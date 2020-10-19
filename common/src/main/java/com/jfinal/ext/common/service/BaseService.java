package com.jfinal.ext.common.service;

import com.jfinal.ext.common.model.BaseModel;
import com.jfinal.ext.common.model.ICondition;
import com.jfinal.ext.common.model.ModelCheck;
import com.jfinal.ext.common.model.PageCondition;
import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Page;

import java.util.List;

/*
    author: Timor
    date: 2019/12/4 0004
*/
public interface BaseService<T extends BaseModel<T>> {
    String namespace = "";

    ModelCheck<T> getModelCheck();

    T findById(Object id);

    T findById(Object...ids);

    boolean add(T model);

    boolean update(T model);

    boolean delete(T model);

    boolean deleteById(Object id);

    boolean deleteByIds(Object...id);


    int[] batchAdd(List<T> model);

    int[] batchUpdate(List<T> model);

    int[] batchDelete(Object[][] ids);

    int[] batchDelete(List<T> entityList);




    T findOneByCondition(ICondition condition);

    List<T> findAllByCondition(ICondition condition);

    Page<T> findPageByCondition(PageCondition condition);



    String getNamespace();

    public Kv getTableMeta();

    Class<T> getModelClass();

//    int deleteByCondition(ICondition condition);
}
