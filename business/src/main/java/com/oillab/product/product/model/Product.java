package com.oillab.product.product.model;

import com.common.base.model.generate.BaseProduct;
import com.jfinal.ext.annotation.TableBind;
import com.jfinal.ext.annotation.TableColDesc;
import com.jfinal.ext.util.rand.MyUUIDUtil;

@SuppressWarnings("serial")
@TableBind(tableName = "product", primaryKey = "id")
public class Product extends BaseProduct<Product> {
    @TableColDesc(name = "id", paraName = "id", label = "产品id", show = false)
    public static final String ID = "id";
    @TableColDesc(name = "name", paraName = "name", label = "产品名称")
    public static final String NAME = "name";
    public static final String CATEGORY = "category";
    public static final String TYPE = "type";
    @TableColDesc(name = "categoryName", paraName = "categoryName", label = "产品种类")
    public static final String CATEGORY_NAME = "categoryName";
    @TableColDesc(name = "typeName", paraName = "categoryName", label = "产品类型")
    public static final String TYPE_NAME = "typeName";
    @TableColDesc(name = "model", paraName = "model", label = "产品型号")
    public static final String MODEL = "model";
    @TableColDesc(name = "coverImg", paraName = "coverImg", label = "产品展示图片", format = "imgFmt")
    public static final String COVER_IMG = "coverImg";
    @TableColDesc(name = "description", paraName = "description", label = "产品简述")
    public static final String DESCRIPTION = "description";
    @TableColDesc(name = "introduction", paraName = "introduction", label = "产品介绍", show = false)
    public static final String INTRODUCTION = "introduction";
    @TableColDesc(name = "resource", paraName = "resource", label = "产品资料", format = "resourceFormat")
    public static final String RESOURCE = "resource";
    @TableColDesc(name = "status", paraName = "status", label = "状态", type = "number", format = "statusFmt")
    public static final String STATUS = "status";

    @Override
    public String checkCommonFiled() {
        return EMPTY_STRING;
    }

    @Override
    public String checkForAdd() {
        return super.checkForAdd(()->{
            this.setId(MyUUIDUtil.getUUID());
            return EMPTY_STRING;
        });
    }

    @Override
    public String checkForUpdate() {
        return super.checkForUpdate(()->{
            return EMPTY_STRING;
        });
    }


    public String getTypeName(){
        return get(TYPE_NAME);
    }

    public String getCategoryName(){
        return get(CATEGORY_NAME);
    }


    public void setTypeName(String typeName){
        set(TYPE_NAME, typeName);
    }

    public void setCategoryName(String categoryName){
        set(CATEGORY_NAME, categoryName);
    }
}
