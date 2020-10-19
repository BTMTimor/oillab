package com.jfinal.ext.common.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.jfinal.ext.common.api.result.ApiResult;
import com.jfinal.ext.common.api.result.ResultCode;
import com.jfinal.ext.common.model.BaseModel;
import com.jfinal.ext.common.model.ICondition;
import com.jfinal.ext.common.model.ModelCheck;
import com.jfinal.ext.common.model.PageCondition;
import com.jfinal.ext.common.service.BaseService;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Page;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/*
    author: Timor
    date: 2020/7/14 0014
*/
public abstract class BaseApiController<T extends BaseModel<T>> extends BaseController<T>  {
    private ModelCheck<T> modelCheck = null;
    private Class<T> modelClass = null;

    protected abstract BaseService<T> getService();

    protected ModelCheck<T> getModelCheck(){
        if(null == modelCheck){
            modelCheck = this.getService().getModelCheck();
        }
        return modelCheck;
    }

    protected Class<T> getModelClass(){
        if(null == modelClass){
            modelClass = this.getService().getModelClass();
        }
        return modelClass;
    }


    // 基本CRUD操作
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    protected ApiResult findById(Object id) {
        String message = checkId(id);
        if (StrKit.notBlank(message)) {
            return ApiResult.error(ResultCode.PARAM_IS_BLANK, message);
        }

        // 查找操作
        T result = getService().findById(id);
        if (null == result) {
            return ApiResult.failure(ResultCode.DATA_NOT_EXIST);
        }
        return ApiResult.success(filterForReturn(result));
    }

    protected ApiResult checkAndAdd(T entity){
        return this.checkAndAdd(entity, () -> "");
    }

    protected ApiResult checkAndAdd(T entity, Supplier<String> otherCheck){
        String result = entity.checkForAdd() ;
        // entity本身校验和外部其他校验
        if(StrKit.notBlank(result) || StrKit.notBlank(result = otherCheck.get())){
            return ApiResult.error(ResultCode.DATA_ADD_ERROR, result);
        }

        if(getService().add(entity)){
            // 成功返回主键id
            return ApiResult.success(ResultCode.DATA_ADD_SUCCESS, entity.getId());
        }
        return ApiResult.failure(ResultCode.DATA_ADD_ERROR);
    }

    protected ApiResult updateModel(T entity){
        if(getService().update(entity)){
            return ApiResult.success(ResultCode.DATA_UPDATE_SUCCESS, entity);
        }
        return ApiResult.failure(ResultCode.DATA_UPDATE_ERROR);
    }

    protected ApiResult checkAndUpdate(T entity){
        return checkAndUpdate(entity, () -> "");
    }

    protected ApiResult checkAndUpdate(T entity, Supplier<String> otherCheck){
        String result = entity.checkForUpdate() ;
        // entity本身校验和外部其他校验
        if(StrKit.notBlank(result) || StrKit.notBlank(result = otherCheck.get())){
            return ApiResult.error(ResultCode.DATA_ADD_ERROR, result);
        }
        return updateModel(entity);
    }

    protected ApiResult deleteById(Object id) {
        return deleteById(id, ()-> "");
    }

    protected ApiResult deleteByIds(Object...id) {
        // 校验id是否合法
        String message = checkId(id);
        if(!message.isEmpty()){
            return ApiResult.error(ResultCode.PARAM_IS_INVALID, message);
        }

        // 删除对象
        if(getService().deleteByIds(id)){
            return ApiResult.success(ResultCode.DATA_DELETE_SUCCESS, true);
        }
        return ApiResult.failure(ResultCode.DATA_DELETE_ERROR);
    }

    protected ApiResult deleteById(Object id, Supplier<String> option) {
        // 校验id是否合法
        String message = checkId(id);
        if(!message.isEmpty()){
            return ApiResult.error(ResultCode.PARAM_IS_INVALID, message);
        }

        // 删除对象
        if(getService().deleteById(id)){
            if(StrKit.isBlank(message = option.get())){
                return ApiResult.success(ResultCode.DATA_DELETE_SUCCESS, true);
            }
            return ApiResult.failure(ResultCode.DATA_DELETE_ERROR, message);
        }
        return ApiResult.failure(ResultCode.DATA_DELETE_ERROR);
    }

/*

    // 通过条件删除记录
    protected ApiResult deleteByCondition(ICondition condition) {
        return deleteByCondition(condition, ()-> null);
    }

    protected boolean _deleteByCondition(ICondition condition){
        return getService().deleteByCondition(condition) >= 0;
    }

    // 通过条件删除记录，option为删除后处理
    protected ApiResult deleteByCondition(ICondition condition, Supplier<String> option) {
        // 校验id是否合法

        String message = condition.check();
        if(!message.isEmpty()){
            return ApiResult.error(ResultCode.PARAM_IS_INVALID, message);
        }

        // 删除对象
        if(_deleteByCondition(condition)){
            if(StrKit.isBlank(message = option.get())){
                return ApiResult.success(ResultCode.DATA_DELETE_SUCCESS, true);
            }
            return ApiResult.failure(ResultCode.DATA_DELETE_ERROR, message);
        }
        return ApiResult.failure(ResultCode.DATA_DELETE_ERROR);
    }
*/



    protected ApiResult fakeDelete(Object id, Consumer<T> operation){
        // 校验id值是否合法
        String message = checkId(id);
        if(StrKit.notBlank(message)){
            return ApiResult.error(ResultCode.PARAM_IS_INVALID, message);
        }

        // 对model修改并提交（这里假删除的实现为改变model状态）
        T model = getService().findById(id);
        if(null != model){
            operation.accept(model);
            return updateModel(model);
        }
        return ApiResult.failure(ResultCode.DATA_NOT_EXIST);
    }


    // JSON数据处理及批量数据操作
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    protected boolean isJOSNData(){
        return getRequest().getContentType().startsWith("application/json");
    }


    // 若需要批量操作数据，则需要子类实现
    protected List<T> processJSONArrayData(){
        return processJSONArrayData(getModelClass());
    }

    /**
     * 通用解析json数组数据
     * @param type model类型
     * @return success：list T or failure：Empty List。
     */
    protected final <M> List<M> processJSONArrayData(Class<M> type){
        List<M> objects = Collections.emptyList();

        // 数据类型校验：必须提交json数据
        if(!isJOSNData()){
            renderJson(ApiResult.error(ResultCode.DATA_IS_WRONG, "数据格式错误！请提交json数据！"));
            return objects;
        }

        // body：json数据载体
        String rawData = getRawData();
        System.out.println("rawData: " + rawData);
        System.out.println("json to: " + type);

        try{// 解析数据
            objects = JSON.parseArray(rawData, type);
        }catch (JSONException e){
            renderJson(ApiResult.error(ResultCode.PARAM_IS_INVALID, "数据解析失败！"));
            // TODO log info
            // log.error("parse rawData: " + rawData + "\n" + e.getMessage());
        }
        System.out.println("transfer: " + objects);
        return objects;
    }

    protected ApiResult commonBatchOperation(Function<T, String> modelCheck, Function<List<T>, ApiResult> func){
        List<T> entityList = processJSONArrayData();

        // empty表示解析失败或者json数据为空
        if(null == entityList || entityList.isEmpty()){
            return ApiResult.error(ResultCode.PARAM_IS_BLANK);
        }

        // 校验model是否合法
        Map<String, String> errorMessage = new HashMap<>();
        for (int i = 0; i < entityList.size(); i++) {
            T entity = entityList.get(i);

            if(entity.isEmpty()){
                errorMessage.put(String.valueOf(i), "请先填写信息！");
                continue;
            }

            // 自定义的数据校验处理
            String message = modelCheck.apply(entity);
            if(StrKit.notBlank(message)){
                // 数据出错
                errorMessage.put(String.valueOf(i), message);
            }
        }


        // 若校验出现问题，则返回错误信息而不执行操作
        if(!errorMessage.isEmpty()){
            return ApiResult.error(ResultCode.PARAM_IS_INVALID, errorMessage);
        }

        // 提交数据并取得执行结果
        return func.apply(entityList);
    }

    protected ApiResult checkAndBatchAdd() {
        return commonBatchOperation(BaseModel::checkForAdd, (entityList)->{
            // 提交数据并取得执行结果
            int[] result = getService().batchAdd(entityList);
            if(result.length > 0){
                return ApiResult.error(ResultCode.DATA_BATCH_ADD_SUCCESS, result);
            }
            return ApiResult.error(ResultCode.DATA_BATCH_ADD_SUCCESS);
        });
    }

    protected ApiResult checkAndBatchUpdate() {
        return commonBatchOperation(BaseModel::checkForUpdate, (entityList)->{
            // 提交数据并取得执行结果
            int[] result = getService().batchUpdate(entityList);
            if(result.length > 0){
                return ApiResult.error(ResultCode.DATA_BATCH_UPDATE_SUCCESS, result);
            }
            return ApiResult.error(ResultCode.DATA_BATCH_UPDATE_ERROR);
        });
    }

    protected ApiResult checkAndBatchDelete() {
        return commonBatchOperation(BaseModel::checkIdForDelete, (entityList)->{
            // 提交数据并取得执行结果
            int[] result = getService().batchDelete(entityList);
            if(result.length > 0){
                return ApiResult.error(ResultCode.DATA_BATCH_DELETE_SUCCESS, result);
            }
            return ApiResult.error(ResultCode.DATA_BATCH_DELETE_ERROR);
        });
    }


    // 数据查找相关
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    protected ApiResult findOneByCondition(ICondition condition) {
        return findOneByCondition(condition, (model)-> model);
    }

    private ApiResult findOneByCondition(ICondition condition, Function<T, T> func) {
        // 校验查询条件
        String message = checkCondition(condition);
        if(!message.isEmpty()){
            return ApiResult.error(ResultCode.PARAM_IS_INVALID, message);
        }

        // 查询数据并返回
        T model = getService().findOneByCondition(condition);
        if(null != model){
            return ApiResult.success(ResultCode.DATA_FIND_SUCCESS, func.apply(model));
        }
        return ApiResult.failure(ResultCode.DATA_FIND_ERROR);
    }

    protected ApiResult findOneAndFilter(ICondition condition) {
        return findOneByCondition(condition, BaseModel::filterForReturn);
    }


    protected ApiResult findPageByCondition(PageCondition condition) {
        return findPageByCondition(condition, (pageData)-> pageData);
    }

    private ApiResult findPageByCondition(PageCondition condition, Function<Page<T>, Page<T>> filter) {
        // 校验查询条件
        String message = checkCondition(condition);
        if(!message.isEmpty()){
            return ApiResult.error(ResultCode.PARAM_IS_INVALID, message);
        }

        // 查询数据并返回
        Page<T> pageData = getService().findPageByCondition(condition);
        if(null != pageData){
            return ApiResult.success(ResultCode.DATA_FIND_SUCCESS, filter.apply(pageData));
        }
        return ApiResult.failure(ResultCode.DATA_FIND_ERROR);
    }

    protected ApiResult findPageAndFilterData(PageCondition condition) {
        return findPageByCondition(condition, this::filterForReturnPage);
    }


    protected ApiResult findAllByCondition(ICondition condition) {
        return findAllByCondition(condition, (listData)-> listData);
    }

    private ApiResult findAllByCondition(ICondition condition, Function<List<T>, List<T>> func) {
        // 校验查询条件
        String message = checkCondition(condition);
        if(!message.isEmpty()){
            return ApiResult.error(ResultCode.PARAM_IS_INVALID, message);
        }

        // 查询数据并返回
        List<T> listData = getService().findAllByCondition(condition);
        if(null != listData){
            return ApiResult.success(ResultCode.DATA_FIND_SUCCESS, func.apply(listData));
        }
        return ApiResult.failure(ResultCode.DATA_FIND_ERROR);
    }

    protected ApiResult findAllAndFilterData(ICondition condition) {
        return findAllByCondition(condition, this::filterForReturnList);
    }


    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // 返回model的元信息
    protected void tableMeta(){
        renderJson(ApiResult.success(getService().getTableMeta()));
    }


    // model过滤
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    protected T filterForReturn(T entity) {
        return entity.filterForReturn();
    }

    protected List<T> filterForReturnList(List<T> entityList) {
        if(!entityList.isEmpty()){
            for (T entity : entityList) {
                entity.filterForReturn();
            }
        }
        return entityList;
    }

    protected Page<T> filterForReturnPage(Page<T> entityPage) {
        filterForReturnList(entityPage.getList());
        return entityPage;
    }


    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -


    protected String checkForAdd(T entity) {
        return entity.checkForAdd();
    }

    protected String checkForUpdate(T entity) {
        return entity.checkForUpdate();
    }

    protected String checkCondition(ICondition condition){
        return getModelCheck().checkForQuery(condition);
    }

    protected String checkId(Object...ids){
        return getModelCheck().checkPrimaryKey(ids);
    }


    // 导入导出 TODO
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - //
    // - - - - - 导入导出Excel文件 - - - - - - - - - - - - - - - - -

    protected ApiResult checkAndImportExcel(){
        return ApiResult.error("Not implemented!");
    }

    protected ApiResult checkAndExportExcel(){
        return ApiResult.error("Not implemented!");
    }

    // - - - - - 导入导出CSV文件 - - - - - - - - - - - - - - - - -

    protected ApiResult checkAndImportCSV(){
        return ApiResult.error("Not implemented!");
    }

    protected ApiResult checkAndExportCSV(){
        return ApiResult.error("Not implemented!");
    }

    // - - - - - 导入导出JSON文件 - - - - - - - - - - - - - - - - -

    protected ApiResult checkAndImportJSON(){
        return ApiResult.error("Not implemented!");
    }

    protected ApiResult checkAndExportJSON(){
        return ApiResult.error("Not implemented!");
    }

    // - - - - - 导入导出JSON文件 - - - - - - - - - - - - - - - - -

    protected ApiResult checkAndImportXML(){
        return ApiResult.error("Not implemented!");
    }

    protected ApiResult checkAndExportXML(){
        return ApiResult.error("Not implemented!");
    }


    // 其他：与具体业务相关
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

}
