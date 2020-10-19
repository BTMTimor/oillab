package xyz.xpman.system.config.model;

import java.io.File;

/*
    author: 江理网猿
    date: 2020/10/5 0005
*/
public class CommonConfig extends BaseConfig{
    public static final String configFileName = SettingManager.getBaseConfigFilePath() + File.separator + "commonConfig.json";
    public static final String backupFilePath = SettingManager.getBaseBackupFilePath() + File.separator + "commonConfig";

    public CommonConfig() {
        super(configFileName, backupFilePath);
    }

}
