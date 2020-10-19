package xyz.xpman.system.config.model;

import java.io.File;

/*
    author: 江理网猿
    date: 2020/10/5 0005
*/
public class AdvanceConfig extends BaseConfig{
    public static final String configFileName = SettingManager.getBaseConfigFilePath() + File.separator + "advancedConfig.json";
    public static final String backupFilePath = SettingManager.getBaseBackupFilePath() + File.separator + "advancedConfig";

    public AdvanceConfig() {
        super(configFileName, backupFilePath);
    }

}
