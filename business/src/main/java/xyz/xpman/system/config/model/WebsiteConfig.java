package xyz.xpman.system.config.model;

import java.io.File;

/*
    author: 江理网猿
    date: 2020/8/24 0024
*/
public class WebsiteConfig extends BaseConfig{
    public static final String configFileName = SettingManager.getBaseConfigFilePath() + File.separator + "websiteConfig.json";
    public static final String backupFilePath = SettingManager.getBaseBackupFilePath() + File.separator + "websiteConfig";

    public WebsiteConfig() {
        super(configFileName, backupFilePath);
    }

    // auto generator: getter and setter
    public static final String NAME = "name";
    public static final String LOGO = "logo";
    public static final String ICON = "icon";
    public static final String KEYWORDS = "keyWords";
    public static final String DESCRIPTION = "description";
    public static final String DOMAIN_NAME = "domainName";
    public static final String SERVER_ADDRESS = "serverAddress";
    public static final String COPYRIGHT = "copyright";
    public static final String CASE_NUMBER = "caseNumber";

    public String getName(){return getStr(NAME);}
    public void setName(String name){set(NAME, name);}
    public String getLogo(){return getStr(LOGO);}
    public void setLogo(String logo){set(LOGO, logo);}
    public String getIcon(){return getStr(ICON);}
    public void setIcon(String icon){set(ICON, icon);}
    public String getKeyWords(){return getStr(KEYWORDS);}
    public void setKeyWords(String keyWords){set(KEYWORDS, keyWords);}
    public String getDescription(){return getStr(DESCRIPTION);}
    public void setDescription(String description){set(DESCRIPTION, description);}
    public String getDomainName(){return getStr(DOMAIN_NAME);}
    public void setDomainName(String domainName){set(DOMAIN_NAME, domainName);}
    public String getServerAddress(){return getStr(SERVER_ADDRESS);}
    public void setServerAddress(String serverAddress){set(SERVER_ADDRESS, serverAddress);}
    public String getCopyright(){return getStr(COPYRIGHT);}
    public void setCopyright(String copyright){set(COPYRIGHT, copyright);}
    public String getCaseNumber(){return getStr(CASE_NUMBER);}
    public void setCaseNumber(String caseNumber){set(CASE_NUMBER, caseNumber);}
}
