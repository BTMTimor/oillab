package com.jfinal.ext.common.service.impl;

import com.jfinal.ext.common.model.BaseModel;
import com.jfinal.ext.common.model.ICondition;
import com.jfinal.ext.common.model.ModelCheck;
import com.jfinal.ext.common.model.PageCondition;
import com.jfinal.ext.common.service.BaseService;
import com.jfinal.ext.plugin.tabledesc.TableDescPlugin;
import com.jfinal.ext.util.clazz.ClassUtil;
import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Page;

import java.util.List;

/*
    author: Timor
    date: 2020/7/14 0014
*/
public abstract class BaseServiceImpl<T extends BaseModel<T>> implements BaseService<T> {
    public static final String FIND_ALL_KEY = "findAllByCondition";
    public static final String FIND_ONE_KEY = "findOneByCondition";
    public static final String FIND_PAGE_KEY = "findPageByCondition";
    private static final String DELETE_BY_CONDITION_KEY = "deleteByCondition";
    protected final BaseModel<T> DAO;

    public BaseServiceImpl() {
        DAO = initDao();
    }

    /**
     * 初始化 DAO
     * 子类可以复写 自定义自己的DAO
     */
    protected T initDao() {
        Class<T> modelClass = (Class<T>) ClassUtil.getGenericClass(getClass());
        if (modelClass == null) {
            throw new RuntimeException("can not get model class name in BaseServiceImpl");
        }

        //默认不通过AOP构建DAO，提升性能，若特殊需要重写initDao()方法即可
        return ClassUtil.newInstance(modelClass, false);
    }

    public BaseModel<T> getDAO() {
        return DAO;
    }

    @Override
    public ModelCheck<T> getModelCheck(){
        return this.DAO;
    }

    @Override
    public Class<T> getModelClass(){
        return (Class<T>) this.DAO.getClass();
    }


    // - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // 返回model的元信息
    @Override
    public Kv getTableMeta(){
        return TableDescPlugin.getTableMeta(DAO.getClass());
    }


    // 需要子类实现：获取sql template的命名空间
    @Override
    public String getNamespace(){
        throw new UnsupportedOperationException();
    }


    // 基础crud
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // 通过id获取记录对象
    @Override
    public T findById(Object id){
        return DAO.findById(id);
    }

    // 通过id获取记录对象
    @Override
    public T findById(Object...ids){
        return DAO.findByIds(ids);
    }

    // 添加一个对象（一条记录）
    @Override
    public boolean add(T model){
        return model.save();
    }

    // 更新一个对象（一条记录）
    @Override
    public boolean update(T model){
        return model.update();
    }

    // 保存或更新对象
    public boolean saveOrUpdate(T model){
        return model.save();
    }


    @Override
    public boolean delete(T model){
        return model.delete();
    }

    // 通过id删除对象
    @Override
    public boolean deleteById(Object id){
        return DAO.deleteById(id);
    }

    // 通过id删除对象
    @Override
    public boolean deleteByIds(Object...ids){
        return DAO.deleteByIds(ids);
    }

/*
    // 通过条件删除对象
    public int deleteByCondition(ICondition condition){
        return deleteByCondition(getNamespace(), condition);
    }

    // 通过条件删除对象
    protected int deleteByCondition(String namespace, ICondition condition){
        return deleteByCondition(namespace, DELETE_BY_CONDITION_KEY, condition);
    }

    // 通过条件删除对象
    protected int deleteByCondition(String namespace, String key, ICondition condition){
        return Db.template((namespace + "." + key), Kv.by("cond", condition)).update();
    }
*/


    // 批量添加对象
    @Override
    public int[] batchAdd(List<T> models){
        return DAO.batchSave(models);
    }

    // 批量更新对象
    @Override
    public int[] batchUpdate(List<T> models){
        return DAO.batchUpdate(models);
    }

    // 批量删除对象
    @Override
    public int[] batchDelete(List<T> models){
        return DAO.batchDelete(models);
    }

    // 通过id数组批量删除对象
    @Override
    public int[] batchDelete(Object[][] ids){
        return DAO.batchDelete(ids);
    }



    // 查找操作
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - -


    // 通过条件查找一条记录
    @Override
    public T findOneByCondition(ICondition condition) {
        return findOneByCondition(getNamespace(), condition);
    }

    // 通过条件查找所有记录
    @Override
    public List<T> findAllByCondition(ICondition condition) {
        return findAllByCondition(getNamespace(), condition);
    }

    // 通过条件分页查找记录
    @Override
    public Page<T> findPageByCondition(PageCondition condition) {
        return findPageByCondition(getNamespace(), condition);
    }


    /**
     * 通过条件查找一条记录
     * @param namespace 唯一标识对应sql template的命名空间
     * @param condition 查找条件
     * @return 精确匹配到的第一条记录
     */
    protected T findOneByCondition(String namespace, ICondition condition){
        return findOneByCondition(namespace, FIND_ONE_KEY, condition);
    }

    /**
     * 通过条件查找一条记录
     * @param namespace 唯一标识对应sql template的命名空间
     * @param key sql template的名称
     * @param condition 查找条件
     * @return 精确匹配到的第一条记录
     */
    protected T findOneByCondition(String namespace, String key, ICondition condition){
        return DAO.template((namespace + "." + key), Kv.by("cond", condition)).findFirst();
    }

    /**
     * 通过条件查找所有记录
     * @param namespace 唯一标识对应sql template的命名空间
     * @param condition 查找条件
     * @return 查找到的所有匹配记录
     */
    protected List<T> findAllByCondition(String namespace, ICondition condition){
        return findAllByCondition(namespace, FIND_ALL_KEY, condition);
    }

    /**
     * 通过条件查找所有记录
     * @param namespace 唯一标识对应sql template的命名空间
     * @param key sql template的名称
     * @param condition 查找条件
     * @return 查找到的所有匹配记录
     */
    protected List<T> findAllByCondition(String namespace, String key, ICondition condition){
        return DAO.template((namespace + "." + key), Kv.by("cond", condition)).find();
    }

    /**
     * 通过条件分页查找记录
     * @param namespace 唯一标识对应sql template的命名空间
     * @param condition 查找条件
     * @return 查找到的分页记录
     */
    protected Page<T> findPageByCondition(String namespace, PageCondition condition){
        return findPageByCondition(namespace, FIND_PAGE_KEY, condition);
    }

    /**
     * 通过条件分页查找记录
     * @param namespace 唯一标识对应sql template的命名空间
     * @param key sql template的名称
     * @param condition 查找条件
     * @return 查找到的分页记录
     */
    protected Page<T> findPageByCondition(String namespace, String key, PageCondition condition){
        return DAO.template((namespace + "." + key), Kv.by("cond", condition))
                .paginate(condition.getPageNumber(), condition.getPageSize());
    }

}
