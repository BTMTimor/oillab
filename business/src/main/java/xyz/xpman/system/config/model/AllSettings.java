package xyz.xpman.system.config.model;

import com.jfinal.ext.util.file.MyFileUtil;
import com.jfinal.log.Log;

import java.io.File;
import java.io.IOException;

/*
    author: 江理网猿
    date: 2020/8/24 0024
*/
public class AllSettings {
    private static final Log log = Log.getLog(AllSettings.class);
    private static final String errorMessage = "\n\tconfig File(%s) must exist(%s), can read(%s) and write(%s).";

    private static final CommonConfig commonConfig = new CommonConfig();
    private static final AdvanceConfig advanceConfig = new AdvanceConfig();
    private static final WebsiteConfig websiteConfig = new WebsiteConfig();
    private static final OrganizationConfig organizationConfig = new OrganizationConfig();

    public static void init() {
        try {
            BaseConfig[] configList = {commonConfig, advanceConfig, websiteConfig, organizationConfig};
            for (BaseConfig config : configList) {
                checkAndInitConfig(config);
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public static void checkAndInitConfig(BaseConfig config) throws Exception {
        checkConfig(config);
        initConfig(config);
    }

    public static void checkConfig(BaseConfig config) throws Exception {
        // 检查配置文件
        String fileName = config.getConfigFileName();
        File file = new File(fileName);
        log.info("configFileName: " + fileName);
        if (!(file.exists() && file.canRead() && file.canWrite())) {
            String temp = String.format(errorMessage, fileName, file.exists(),
                    file.canRead(), file.canWrite());
            throw new IOException(temp);
        }

        String filePath = config.getBackupFilePath();
        file = new File(filePath);
        log.info("backupFilePath: " + filePath);
        if (!file.exists()){
            // todo 处理步不成功之情况
            log.info("mkdirs(" + file.mkdirs() + "): " + filePath);
        }

        if(!file.isDirectory()){
            throw new IOException("file(" + filePath + ") must be directory!");
        }
    }

    public static void initConfig(BaseConfig config) throws IOException {
        config.setColumns(MyFileUtil.readFileToJavaObject(config.getConfigFileName(), config.getClass()));
    }


    /*public static boolean saveConfig(BaseConfig config) throws IOException {
        return config.saveConfig();
    }*/


    // common config

    public static CommonConfig getCommonConfig() {
        return commonConfig;
    }

    public static boolean saveCommonConfig(CommonConfig config) throws IOException {
        return commonConfig.saveConfig(config);
    }

    // organization config

    public static OrganizationConfig getOrganizationConfig() {
        return organizationConfig;
    }

    public static boolean saveOrganizationConfig(OrganizationConfig config) throws IOException {
        return organizationConfig.saveConfig(config);
    }


    // advance config

    public static AdvanceConfig getAdvanceConfig() {
        return advanceConfig;
    }

    public static boolean saveAdvanceConfig(AdvanceConfig config) throws IOException {
        return advanceConfig.saveConfig(config);
    }

    // website config

    public static WebsiteConfig getWebsiteConfig() {
        return websiteConfig;
    }

    public static boolean saveWebsiteConfig(WebsiteConfig config) throws IOException {
        return websiteConfig.saveConfig(config);
    }

}
