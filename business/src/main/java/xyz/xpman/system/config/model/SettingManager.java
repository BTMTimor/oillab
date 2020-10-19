package xyz.xpman.system.config.model;

import com.jfinal.kit.PathKit;
import com.jfinal.kit.StrKit;

import java.io.File;

/*
    author: 江理网猿
    date: 2020/10/5 0005
*/
public class SettingManager {
    private static final String webRootPath = PathKit.getWebRootPath();
    private static final String configPath = "config";
    private static final String backupPath = "config" + File.separator + "backup";
    private static boolean isInit;
    private static String baseConfigFilePath;
    private static String baseBackupFilePath;

    public static void init(String baseTemplatePath){
        baseTemplatePath = StrKit.notBlank(baseTemplatePath) ? File.separator + baseTemplatePath : "";
        // System.out.println("[SettingManager] webRootPath: " + webRootPath);
        String baseConfigFilePath = webRootPath + baseTemplatePath + File.separator + configPath;
        String baseBackupFilePath = webRootPath + baseTemplatePath + File.separator + backupPath;
        // System.out.println("baseConfigFilePath: " + baseConfigFilePath);
        // System.out.println("baseBackupFilePath: " + baseBackupFilePath);
        init(baseConfigFilePath, baseBackupFilePath);
    }

    public static void init(String baseConfigFilePath, String baseBackupFilePath) {
        if(isInit) {return;}

        SettingManager.baseConfigFilePath = baseConfigFilePath;
        SettingManager.baseBackupFilePath = baseBackupFilePath;
        AllSettings.init();
        isInit = true;
    }

    public static String getBaseConfigFilePath(){
        return baseConfigFilePath;
    }

    public static String getBaseBackupFilePath(){
        return baseBackupFilePath;
    }
}
