package com.jfinal.ext.common.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.jfinal.plugin.activerecord.*;

import java.util.List;
import java.util.function.Supplier;

/*
    author: Timor
    date: 2020/7/14 0014
*/
@SuppressWarnings({"serial", "unchecked"})
public class BaseModel<T extends BaseModel<T>> extends Model<T> implements ModelCheck<T>, IBean {
    public static final String EMPTY_STRING = "";

    // 每个model都设置id为主键，便于操作，
    /*public void setId(Object id) {
        set("id", id);
    }*/

    // id
    public Object getId() {
        return get("id");
    }

    public boolean isEmpty(){
        return this._getAttrs().isEmpty();
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - -  - - - - -

    protected DbPro getDbPro(){
        return new DbPro(DbKit.MAIN_CONFIG_NAME);
    }

    public int[] batchSave(List<T> models){
        return getDbPro().batchSave(models, 10);
    }

    public int[] batchUpdate(List<T> models){
        return getDbPro().batchUpdate(models, 10);
    }

    public int[] batchDelete(List<T> models){
        Object[][] ids = new Object[models.size()][];
        String[] primaryKeys = models.get(0).getTablePrimaryKeys();
        // 将models的model的主键们转化为id数组，顺序与primaryKey的顺序一致
        for (int i = 0; i < models.size(); i++) {
            T model = models.get(i);
            ids[i] = new Object[primaryKeys.length];
            for (int j = 0; j < primaryKeys.length; j++) {
                ids[i][j] = model.get(primaryKeys[j]);
            }
        }
        return batchDelete(ids);
    }

    public int[] batchDelete(Object[][] ids){
        String[] primaryKeys = this.getTablePrimaryKeys();
        StringBuilder conditions = new StringBuilder();
        if(primaryKeys.length > 0){
            for (String primaryKey : primaryKeys) {
                conditions.append(" and ").append(primaryKey).append(" = ?");
            }

            String sql = "DELETE FROM " + this.getDbTableName() + " WHERE 1 = 1 " + conditions;
            return getDbPro().batch(sql, ids, 500);
        }
        return new int[0];
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - -  - - - - -

    // 返回数据前过滤掉敏感字段，建议sql查询的时候不查询敏感字段
    public T filterForReturn(){return (T) this;}

    // 返回数据前过滤掉敏感字段，建议sql查询的时候不查询敏感字段
    @Override
    public Page<T> filterForReturn(Page<T> page) {
        List<T> list = page.getList();
        if (!list.isEmpty()){
            for (T model : list){
                model.filterForReturn();
            }
        }
        return page;
    }



    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @JSONField(serialize=false)
    public final String getDbTableName(){
        return this._getTable().getName();
    }

    @Override
    @JSONField(serialize=false)
    public final String[] getTablePrimaryKeys(){
        return this._getTable().getPrimaryKey();
    }


    // model check method
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // 检查主键是否都有合法值
    public final String checkPrimaryKey(){
        return checkPrimaryKeys((T) this);
    }

    @Override
    public final String checkPrimaryKey(Object... values) {
        return checkPrimaryKey((T)this, values);
    }


    // 检查Model添加和修改公共的字段信息
    public String checkCommonFiled(){return EMPTY_STRING;}

    @Override
    public final String checkCommonFiled(T model) {
        return model.checkCommonFiled();
    }



    protected final String commonCheck(Supplier<String> otherOperation){
        return commonCheck((T)this, otherOperation);
    }



    // 为添加记录检查字段并做预添加处理
    public String checkForAdd() {
        return checkForAdd(() -> EMPTY_STRING);
    }

    // 为添加记录检查字段并做预添加处理
    protected final String checkForAdd(Supplier<String> otherOperation) {
        return checkForAdd((T)this, otherOperation);
    }



    // 检查id准备删除记录
    public String checkIdForDelete() {
        return checkPrimaryKey();
    }

    // 检查id准备删除记录
    @Override
    public final String checkIdForDelete(Object... values){
        return checkIdForDelete((T)this, values);
    }


    // 为添加记录检查字段并做预添加处理
    public String checkForUpdate() {
        return checkForUpdate(() -> EMPTY_STRING);
    }

    // 为添加记录检查字段并做预添加处理
    protected final String checkForUpdate(Supplier<String> otherOperation) {
        return checkForUpdate((T)this, otherOperation);
    }



    // 检查查询参数
    @Override
    public String checkForQuery(ICondition condition) {
        return condition.check();
    }

}
