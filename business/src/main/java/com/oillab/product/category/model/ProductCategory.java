package com.oillab.product.category.model;

import com.common.base.model.generate.BaseProductCategory;
import com.jfinal.ext.annotation.TableBind;
import com.jfinal.ext.annotation.TableColDesc;
import com.jfinal.ext.util.rand.MyUUIDUtil;

/**
 * Generated by JFinal.
 */
@SuppressWarnings("serial")
@TableBind(tableName = "product_category", primaryKey = "id")
public class ProductCategory extends BaseProductCategory<ProductCategory> {
    @TableColDesc(name = "id", paraName = "id", label = "产品种类id", type = "text")
    public static final String ID = "id";
    @TableColDesc(name = "name", paraName = "name", label = "产品种类名称", type = "text")
    public static final String NAME = "name";
    @TableColDesc(name = "description", paraName = "description", label = "产品种类简述", type = "text")
    public static final String DESCRIPTION = "description";
    @TableColDesc(name = "status", paraName = "status", label = "状态", type = "number", format = "statusFmt")
    public static final String STATUS = "status";



    @Override
    public String checkForAdd() {
        return super.checkForAdd(()->{
            setId(MyUUIDUtil.getUUID());
            return EMPTY_STRING;
        });
    }
}