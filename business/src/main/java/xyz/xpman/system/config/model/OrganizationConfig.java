package xyz.xpman.system.config.model;

import java.io.File;

/*
    author: 江理网猿
    date: 2020/10/4 0004
*/
public class OrganizationConfig extends BaseConfig{
    public static final String configFileName = SettingManager.getBaseConfigFilePath() + File.separator + "organizationConfig.json";
    public static final String backupFilePath = SettingManager.getBaseBackupFilePath() + File.separator + "organizationConfig";

    public OrganizationConfig() {
        super(configFileName, backupFilePath);
    }

    public String getName(){return get("name");}
    public void setName(String name){set("name", name);}

    public String getAddress(){return get("address");}
    public void setAddress(String address){set("address", address);}

    public String getMapAddress(){return get("mapAddress");}
    public void setMapAddress(String mapAddress){set("mapAddress", mapAddress);}

    public String getDescription(){return get("description");}
    public void setDescription(String description){set("description", description);}

    public String getEmail(){return get("email");}
    public void setEmail(String email){set("email", email);}

    public String getOfficialAccount(){return get("officialAccount");}
    public void setOfficialAccount(String officialAccount){set("officialAccount", officialAccount);}

    public String getWeChat(){return get("WeChat");}
    public void setWeChat(String WeChat){set("WeChat", WeChat);}

    public String getWeChatImg(){return get("WeChatImg");}
    public void setWeChatImg(String WeChatImg){set("WeChatImg", WeChatImg);}

    public String getPhone(){return get("phone");}
    public void setPhone(String phone){set("phone", phone);}

    public String getIcon(){return get("icon");}
    public void setIcon(String icon){set("icon", icon);}

    public String getLogo(){return get("logo");}
    public void setLogo(String logo){set("logo", logo);}

    public String getIndexShowImg(){return get("indexShowImg");}
    public void setIndexShowImg(String indexShowImg){set("indexShowImg", indexShowImg);}

    public String getIntroduceVideoUrl(){return get("introduceVideoUrl");}
    public void setIntroduceVideoUrl(String introduceVideoUrl){set("introduceVideoUrl", introduceVideoUrl);}

    public String getIntroduceTestVideoUrl(){return get("introduceTestVideoUrl");}
    public void setIntroduceTestVideoUrl(String introduceTestVideoUrl){set("introduceTestVideoUrl", introduceTestVideoUrl);}

    public String getVideoCover(){return get("videoCover");}
    public void setVideoCover(String videoCover){set("videoCover", videoCover);}
}
