package com.jfinal.ext.kit;

import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;

import java.util.HashSet;
import java.util.Set;

/*
    author: 江理网猿
    date: 2020/8/1 0001
*/
public class ConfigKit {
    public static final String DEV_MODE = "common.devMode";
    public static final String BASE_UPLOAD_URL = "common.baseUploadUrl";
    public static final String BASE_UPLOAD_PATH = "common.baseUploadPath";
    public static final String BASE_DOWNLOAD_URL = "common.baseDownloadUrl";
    public static final String BASE_DOWNLOAD_PATH = "common.baseDownloadPath";
    public static final String BASE_TEMPLATE_PATH = "common.baseTemplatePath";
    public static final String ENCODING = "common.encoding";
    public static final String SCAN_JARS = "common.scanJars";
    public static final String SCAN_PACKAGES = "common.scanPackages";
    public static final String MAX_POST_SIZE = "common.maxPostSize";
    public static final String VIEW_EXTENSION = "common.viewExtension";
    public static final String DENY_ACCESS_JSP = "common.denyAccessJsp";
    public static final String URL_PARA_SEPARATOR = "common.urlParaSeparator";
    // jdbc相关配置
    public static final String JDBC_URL = "jdbc.url";
    public static final String JDBC_USERNAME = "jdbc.username";
    public static final String JDBC_PASSWORD = "jdbc.password";
    // druid监控url
    public static final String DRUID_MONITOR = "druid.monitor";
    private static final String BASE_VIEW_PATH = "common.viewPath";
    private static final String PACKING = "common.packing";

    private static final Set<String> PACKING_FORMAT = new HashSet<String>(){{
        add("jar"); add("zip"); add("war"); add("tar"); add("tar.gz"); add("true");
    }};
    private static final String IS_TEMPLATE_IN_CLASS_PATH = "common.template.inClassPath";

    // jfinal config
    private boolean devMode = false;
    private String encoding = "UTF-8";
    private String urlParaSeparator = "-";
    private String viewExtension = ".html";
    // 10M;
    private int maxPostSize = 2000 * 1024 * 1024;
    private boolean denyAccessJsp = true;
    // other config
    private String baseUploadUrl = "/upload";
    private String baseUploadPath = "/upload";
    private String baseDownloadUrl = "/download";
    private String baseDownloadPath = "/download";
    // 扫描jar包设置
    private String scanJars = "";
    private String scanPackages = "";

    // db config
    // jdbc.private String driver;
    private String jdbcUrl;
    private String jdbcUsername;
    private String jdbcPassword;

    // dbcp config
    private String druidMonitor = "/druid/monitor";
    private boolean isPacking = false;
    private String baseViewPath;
    private String baseTemplatePath = "";
    private String packing = "dir";
    private boolean isTemplateInClassPath = false;

    public ConfigKit(String...configFileName) {
        init(PropKit.useFirstFound(configFileName));
    }

    public ConfigKit(Prop prop) {
        init(prop);
    }

    public void init(Prop prop){
        this.encoding = prop.get(ENCODING, encoding);
        this.scanJars = prop.get(SCAN_JARS, scanJars);
        this.scanPackages = prop.get(SCAN_PACKAGES, scanPackages);
        this.devMode = prop.getBoolean(DEV_MODE, devMode);
        this.packing = prop.get(PACKING, packing);
        this.isTemplateInClassPath = prop.getBoolean(IS_TEMPLATE_IN_CLASS_PATH, isTemplateInClassPath);
        this.isPacking = PACKING_FORMAT.contains(packing);
        this.urlParaSeparator = prop.get(URL_PARA_SEPARATOR, urlParaSeparator);
        this.viewExtension = prop.get(VIEW_EXTENSION, viewExtension);
        this.maxPostSize = prop.getInt(MAX_POST_SIZE, maxPostSize);
        this.denyAccessJsp = prop.getBoolean(DENY_ACCESS_JSP, true);
        this.baseViewPath = prop.get(BASE_VIEW_PATH, baseViewPath);
        this.baseUploadUrl = prop.get(BASE_UPLOAD_URL, baseUploadUrl);
        this.baseUploadPath = prop.get(BASE_UPLOAD_PATH, baseUploadPath);
        this.baseDownloadUrl = prop.get(BASE_DOWNLOAD_URL, baseDownloadUrl);
        this.baseDownloadPath = prop.get(BASE_DOWNLOAD_PATH, baseUploadUrl);
        this.baseTemplatePath = prop.get(BASE_TEMPLATE_PATH, baseTemplatePath);

        this.jdbcUrl = prop.get(JDBC_URL).trim();
        this.jdbcUsername = prop.get(JDBC_USERNAME).trim();
        this.jdbcPassword = prop.get(JDBC_PASSWORD).trim();

        this.druidMonitor = prop.get(DRUID_MONITOR, druidMonitor);
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public boolean isDevMode() {
        return devMode;
    }

    public String getEncoding() {
        return encoding;
    }

    public String getUrlParaSeparator() {
        return urlParaSeparator;
    }

    public String getViewExtension() {
        return viewExtension;
    }

    public int getMaxPostSize() {
        return maxPostSize;
    }

    public boolean isDenyAccessJsp() {
        return denyAccessJsp;
    }

    public String getBaseUploadUrl() {
        return baseUploadUrl;
    }

    public String getBaseUploadPath() {
        return baseUploadPath;
    }

    public String getBaseDownloadUrl() {
        return baseDownloadUrl;
    }

    public String getBaseDownloadPath() {
        return baseDownloadPath;
    }

    public String getScanJars() {
        return scanJars;
    }

    public String getScanPackages() {
        return scanPackages;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public String getJdbcUsername() {
        return jdbcUsername;
    }

    public String getJdbcPassword() {
        return jdbcPassword;
    }

    public String getDruidMonitor() {
        return druidMonitor;
    }

    public boolean isPacking() {
        return isPacking;
    }

    public String getBaseViewPath() {
        return baseViewPath;
    }

    public String getBaseTemplatePath() {
        return baseTemplatePath;
    }

    public boolean isTemplateInClassPath() {
        return isTemplateInClassPath;
    }
}
