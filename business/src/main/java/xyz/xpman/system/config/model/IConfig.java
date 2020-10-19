package xyz.xpman.system.config.model;

import com.jfinal.plugin.activerecord.Record;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/*
    author: 江理网猿
    date: 2020/10/3 0003
*/
public interface IConfig {

    default File getConfigFile(){
        return new File(getConfigFileName());
    };

    String getConfigFileName();

    String getBackupFileName();

    Map<String, Object> getConfigs();

    Record removeNullValueColumns();

    // 记录变动值
    boolean recordChange(IConfig config);

    // 获取配置
    //IConfig getConfig();

    // 保存配置
    default boolean saveConfig() throws IOException {
        return saveConfig(this);
    }

    // 写的过程中失败会导致错误（应先备份）
    boolean saveConfig(IConfig config) throws IOException;

    String toJson();
}
