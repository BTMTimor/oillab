package com.jfinal.ext.common.model;

import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Page;

import java.util.List;
import java.util.function.Supplier;

/*
    author: Timor
    date: 2020/7/14 0014
*/
public interface ModelCheck<M extends BaseModel<M>>{
    String EMPTY_STRING = "";
    String MUST_NOT_EMPTY = "不能为空！";

    String[] getTablePrimaryKeys();

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -


    // 返回数据前过滤掉敏感字段，建议sql查询的时候不查询敏感字段
    default M filterForReturn(M model){
        return model;
    }

    // 返回数据前过滤掉敏感字段，建议sql查询的时候不查询敏感字段
    default Page<M> filterForReturn(Page<M> page) {
        List<M> list = page.getList();
        if (!list.isEmpty()){
            for (M model : list){
                filterForReturn(model);
            }
        }
        return page;
    }



    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // 校验主键是否合法
    String checkPrimaryKey(Object...values);

    default String checkPrimaryKeys(M model){
        String[] primaryKeys = model.getTablePrimaryKeys();
        if(primaryKeys.length > 0){
            for (String primaryKey : primaryKeys) {
                if (null == model.get(primaryKey)) {
                    return (primaryKey + MUST_NOT_EMPTY);
                }
            }
        }
        return EMPTY_STRING;
    }

    default String checkPrimaryKey(M model, Object...values){
        String[] primaryKeys = model.getTablePrimaryKeys();
        if(primaryKeys.length > 1 && values.length > 1){
            int minLength = Math.min(primaryKeys.length, values.length);

            // 遍历主键与对应的值
            for (int i = 0; i < minLength; i++) {
                if(null == values[i] ||
                        (values[i].getClass() == String.class && "".equals(values[i]))){
                    return primaryKeys[i] + MUST_NOT_EMPTY;
                }
            }

            // value比主键key多的话不管它
            if(primaryKeys.length > values.length){
                return primaryKeys[minLength] + MUST_NOT_EMPTY;
            }
        }
        return EMPTY_STRING;
    }




    String checkCommonFiled(M model);

    // 检查Model添加和修改公共的字段信息, 先校验必填字段，再运行其他操作（设置id等），最后校验id
    default String commonCheck(M model, Supplier<String> otherOperation){
        String result;

        // 校验普通字段
        if(StrKit.notBlank(result = checkCommonFiled(model))){
            return result;
        }

        // 其他校验和操作，比如主键
        if(StrKit.notBlank(result = otherOperation.get())){
            return result;
        }

        // 校验主键：防止忘记设置
        return checkPrimaryKey(model);
    }



    // 检查字段并做预添加处理
    default String checkForAdd(M model) {
        return checkForAdd(model, () -> EMPTY_STRING);
    }


    default String checkForAdd(M model, Supplier<String> otherOperation) {
        return commonCheck(model.removeNullValueAttrs(), otherOperation);
    }




    // 检查字段并做预添加处理
    String checkIdForDelete(Object...values);

    default String checkIdForDelete(M model, Object...values){
        return checkPrimaryKey(model, values);
    }



    // 检查字段并做预修改处理
    default String checkForUpdate(M model) {
        return checkForUpdate(model, () -> EMPTY_STRING);
    }

    // 检查字段并做预修改处理, id一般不会为空，所以放到最后校验（默认校验顺序）
    default String checkForUpdate(M model, Supplier<String> otherOperation) {
        return commonCheck(model, otherOperation);
    }



    // 检查查询参数
    default String checkForQuery(ICondition condition) {
        if(null == condition){
            return "condition is missing";
        }
        return condition.check();
    }


}
