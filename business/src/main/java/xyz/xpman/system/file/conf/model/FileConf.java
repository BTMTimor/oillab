package xyz.xpman.system.file.conf.model;

import com.common.base.model.generate.BaseFileConf;
import com.jfinal.ext.annotation.TableBind;

import java.util.Arrays;
import java.util.HashSet;

/**
 * author: Timor
 * date: 2020-9-10
 *  description: …… */
@TableBind(tableName = "file_conf", primaryKey = "id")
public class FileConf extends BaseFileConf<FileConf> {

    public boolean accessType(String fileType){
//        CacheKit.put(, , );
        HashSet<String> accessTypes = new HashSet<>(Arrays.asList(getTypeLimit().split("\\|")));
        return accessTypes.contains(fileType);
    }

    @Override
    public String checkCommonFiled() {
        return EMPTY_STRING;
    }

    @Override
    public String checkForAdd() {
        return super.checkForAdd(()->{
            return EMPTY_STRING;
        });
    }

    @Override
    public String checkForUpdate() {
        return super.checkForUpdate(()->{
            return EMPTY_STRING;
        });
    }
}
