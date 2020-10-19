package xyz.xpman.system.config.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.jfinal.ext.util.file.MyFileUtil;
import com.jfinal.plugin.activerecord.Record;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/*
    author: 江理网猿
    date: 2020/10/4 0004
*/
public class BaseConfig extends Record implements IConfig{
    protected static final SimpleDateFormat defaultDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss-SS");
    private final String configFileName;
    private final String backupFilePath;


    public BaseConfig(String configFileName, String backupFilePath) {
        this.configFileName = configFileName;
        this.backupFilePath = backupFilePath;
    }

    @Override
    @JSONField(serialize = false)
    public String getConfigFileName(){
        return this.configFileName;
    }

    @JSONField(serialize = false)
    public String getBackupFilePath(){
        return this.backupFilePath;
    }

    @Override
    @JSONField(serialize = false)
    public String getBackupFileName(){
        return this.backupFilePath + File.separator + defaultDateFormat.format(new Date()) + ".bak";
    }

    @Override
    @JSONField(serialize = false)
    public Map<String, Object> getConfigs() {
        return this.getColumns();
    }

    @Override
    public synchronized boolean recordChange(IConfig config) {
        config.removeNullValueColumns();
        Map<String, Object> columns = config.getConfigs();
        if (!columns.isEmpty()) {
            this.setColumns(columns);
            return true;
        }
        return false;
    }

    @Override
    public synchronized boolean saveConfig(IConfig config) throws IOException {
        System.out.println("saveConfig: " + config.toJson());
        if (!recordChange(config)) {
            return true;
        }

        File file = getConfigFile();

        // 备份配置文件
        String backupFileName = getBackupFileName();
        System.out.println("备份配置：" + backupFileName);
        MyFileUtil.copyFileToFile(file, new File(backupFileName));

        // 保存配置
        System.out.println("保存配置：" + config);
        try {
            MyFileUtil.writeStringToFile(config.toJson(), file);
        } catch (IOException exception) {
            exception.printStackTrace();
            // 若失败，则将备份文件还原
            System.out.println("还原配置：" + backupFileName);
            MyFileUtil.copyFileToFile(new File(backupFileName), file);

            return false;
        }
        return true;
    }

    @Override
    public String toJson() {
        return super.toJson();
    }
}
