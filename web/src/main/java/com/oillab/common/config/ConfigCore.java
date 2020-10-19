package com.oillab.common.config;

import com.jfinal.log.Log;

/**
 * 独立启动JFinal中的插件，不依赖web容器调用插件
 * author: Timor
 * date: 2020/2/8 0008
 * 描述：独立启用核心组件主要给单元测试、代码生成器使用
 */
public class ConfigCore {
    private static final Log log = Log.getLog(ConfigCore.class);

    private static volatile ConfigCore configCore;

    public static ConfigCore getSingleton(){
        if(configCore == null){
            synchronized (ConfigCore.class) {
                if(configCore == null){
                    configCore = new ConfigCore();
                }
            }
        }
        return configCore;
    }

    private ConfigCore() {

    }

}
