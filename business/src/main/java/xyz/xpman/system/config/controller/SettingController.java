package xyz.xpman.system.config.controller;

import com.jfinal.core.Controller;
import com.jfinal.ext.annotation.RequestMapping;
import xyz.xpman.system.config.model.AllSettings;

/*
    author: 江理网猿
    date: 2020/8/12 0012
*/
@RequestMapping(value = "/setting", viewPath = "/view/backstage/sys/setting")
public class SettingController extends Controller {

    public void index(){
        render("setting.html");
    }

    public void website(){
        setAttr("entity", AllSettings.getWebsiteConfig());
        render("website.html");
    }

    public void common(){
        setAttr("entity", AllSettings.getCommonConfig());
        render("common.html");
    }

    public void organization(){
        setAttr("entity", AllSettings.getOrganizationConfig());
        render("organization.html");
    }

    public void advance(){
        setAttr("entity", AllSettings.getAdvanceConfig());
        render("advance.html");
    }

    public void friendChain(){
        render("friendChain.html");
    }


}
