package xyz.xpman.system.dict.model;

import com.common.base.model.generate.BaseSysDictType;
import com.jfinal.ext.annotation.TableBind;
import com.jfinal.ext.annotation.TableColDesc;
import com.jfinal.ext.annotation.TableDesc;
import com.jfinal.ext.util.rand.MyUUIDUtil;
import com.jfinal.kit.StrKit;

@SuppressWarnings("serial")
@TableBind(tableName = "sys_dict_type", primaryKey = "id")
@TableDesc(label = "字典类型", width = "100%", height = "675px")
public class DictType extends BaseSysDictType<DictType> {
    @TableColDesc(name = "id", paraName = "id", label = "id", type = "string")
    public static final String ID = "id";
    @TableColDesc(name = "name", paraName = "name", label = "字典名称", type = "text")
    public static final String NAME = "name";
    @TableColDesc(name = "type", paraName = "type", label = "字典类型", type = "text")
    public static final String TYPE = "type";
    @TableColDesc(name = "description", paraName = "description", label = "备注", type = "text")
    public static final String DESCRIPTION = "description";
    @TableColDesc(name = "status", paraName = "status", label = "状态", type = "number", format = "statusFmt")
    public static final String STATUS = "status";

    @Override
    public String checkCommonFiled() {
        if(StrKit.isBlank(getName())){
            return "字典名不能为空!";
        }
        if(StrKit.isBlank(getType())){
            return "字典类型不能为空!";
        }
        return EMPTY_STRING;
    }

    @Override
    public String checkForAdd() {
        return checkForAdd(()->{
            this.setId(MyUUIDUtil.getUUID());
            return EMPTY_STRING;
        });
    }

}
