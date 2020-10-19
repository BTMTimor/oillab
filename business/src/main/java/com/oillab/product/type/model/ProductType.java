package com.oillab.product.type.model;

import com.common.base.model.generate.BaseProductType;
import com.jfinal.ext.annotation.TableBind;
import com.jfinal.ext.annotation.TableColDesc;
import com.jfinal.ext.util.rand.MyUUIDUtil;
import com.jfinal.kit.StrKit;

@SuppressWarnings("serial")
@TableBind(tableName = "product_type", primaryKey = "id")
public class ProductType extends BaseProductType<ProductType> {
    @TableColDesc(name = "id", paraName = "id", label = "产品类型ID", type = "text")
    public static final String ID = "id";
    @TableColDesc(name = "category", paraName = "category", label = "产品种类", type = "text")
    public static final String CATEGORY = "category";
    @TableColDesc(name = "name", paraName = "name", label = "产品种类名称", type = "text")
    public static final String NAME = "name";
    @TableColDesc(name = "description", paraName = "description", label = "产品种类简述", type = "text")
    public static final String DESCRIPTION = "description";
    @TableColDesc(name = "status", paraName = "status", label = "状态", type = "number", format = "statusFmt")
    public static final String STATUS = "status";


    @Override
    public String checkCommonFiled() {
        if(StrKit.isBlank(getName())){
            return "名字不能为空！";
        }
        if(StrKit.isBlank(getCategory())){
            return "种类不能为空！";
        }
        return EMPTY_STRING;
    }

    @Override
    public String checkForUpdate() {
        return super.checkForUpdate();
    }

    @Override
    public String checkForAdd() {
        return super.checkForAdd(()->{
            this.setId(MyUUIDUtil.getUUID());
            return EMPTY_STRING;
        });
    }
}
