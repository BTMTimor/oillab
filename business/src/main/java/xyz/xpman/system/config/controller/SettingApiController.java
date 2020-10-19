package xyz.xpman.system.config.controller;

import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.core.paragetter.Para;
import com.jfinal.ext.annotation.RequestMapping;
import com.jfinal.ext.common.api.result.ApiResult;
import xyz.xpman.system.config.model.*;

import java.io.IOException;

/*
    author: 江理网猿
    date: 2020/8/12 0012
*/
@RequestMapping(value = "/api/v1/setting")
public class SettingApiController extends Controller {

    @ActionKey("/api/v1/config/commonInfo")
    public void commonInfo(){
        render("/config/common-info.json");
    }


    // 机构信息设置
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @ActionKey("/api/v1/setting/organization/get")
    public void getOrganizationConfig(){
        renderJson(ApiResult.success(AllSettings.getOrganizationConfig()));
    }

    @ActionKey("/api/v1/setting/organization/update")
    public void saveOrganizationConfig(@Para("") OrganizationConfig config){
        try {
            renderJson(ApiResult.successOrFailure(AllSettings.saveOrganizationConfig(config)));
        } catch (IOException exception) {
            processError(exception);
            renderJson(ApiResult.failure());
        }
    }

    // 通用设置
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @ActionKey("/api/v1/setting/common/get")
    public void getCommonConfig(){
        renderJson(ApiResult.success(AllSettings.getCommonConfig()));
    }

    @ActionKey("/api/v1/setting/common/update")
    public void saveCommonConfig(@Para("") CommonConfig config){
        try {
            renderJson(ApiResult.successOrFailure(AllSettings.saveCommonConfig(config)));
        } catch (IOException exception) {
            processError(exception);
            renderJson(ApiResult.failure());
        }
    }


    // 高级设置
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @ActionKey("/api/v1/setting/advance/get")
    public void getAdvanceConfig(){
        renderJson(ApiResult.success(AllSettings.getAdvanceConfig()));
    }

    @ActionKey("/api/v1/setting/advance/update")
    public void saveAdvanceConfig(@Para("") AdvanceConfig config){
        try {
            renderJson(ApiResult.successOrFailure(AllSettings.saveAdvanceConfig(config)));
        } catch (IOException exception) {
            processError(exception);
            renderJson(ApiResult.failure());
        }
    }


    // 网站设置
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @ActionKey("/api/v1/setting/website/get")
    public void getWebsiteConfig(){
        renderJson(ApiResult.success(AllSettings.getWebsiteConfig()));
    }

    @ActionKey("/api/v1/setting/website/update")
    public void saveWebsiteConfig(@Para("") WebsiteConfig config){
        try {
            renderJson(ApiResult.successOrFailure(AllSettings.saveWebsiteConfig(config)));
        } catch (IOException exception) {
            processError(exception);
            renderJson(ApiResult.failure());
        }
    }


    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    private void processError(Exception exception){
        exception.printStackTrace();
    }

}
