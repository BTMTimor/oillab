package com.oillab.modular.type.model;

import com.common.base.model.generate.BaseModularType;
import com.jfinal.ext.annotation.TableBind;
import com.jfinal.ext.annotation.TableColDesc;
import com.jfinal.kit.StrKit;

@SuppressWarnings("serial")
@TableBind(tableName = "modular_type", primaryKey = "id")
public class ModularType extends BaseModularType<ModularType> {
    @TableColDesc(name = "id", paraName = "id", label = "id")
    public static final String ID = "id";
    @TableColDesc(name = "name", paraName = "name", label = "名称")
    public static final String NAME = "name";
    @TableColDesc(name = "title", paraName = "title", label = "标题")
    public static final String TITLE = "title";
    @TableColDesc(name = "description", paraName = "description", label = "描述")
    public static final String DESCRIPTION = "description";
    @TableColDesc(name = "status", paraName = "status", label = "状态", type = "number", format = "statusFmt")
    public static final String STATUS = "status";


    @Override
    public String checkCommonFiled() {
        if(StrKit.isBlank(getName())){
            return "名字不能为空！";
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
            return EMPTY_STRING;
        });
    }
}
