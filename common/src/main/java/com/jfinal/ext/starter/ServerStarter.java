package com.jfinal.ext.starter;

import com.jfinal.config.JFinalConfig;
import com.jfinal.ext.util.resources.ResourcesUtil;
import com.jfinal.server.undertow.UndertowServer;

/*
    author: 江理网猿
    date: 2020/10/18 0018
*/
public class ServerStarter {
    private static final String LOCAL_CONFIG_FILE =  "undertow-local.conf";
    private static final String LOCAL_TEST_CONFIG_FILE =  "undertow-local-test.conf";
    private static final String SERVER_CONFIG_FILE = "undertow-server.conf";
    private static final String SERVER_TEST_CONFIG_FILE = "undertow-server-test.conf";

    /**
     * 以默认方式启动 undertowServer
     * @param clazz 配置类
     */
    public static void run(Class<? extends JFinalConfig> clazz) {
        run(clazz, new String[]{
                LOCAL_CONFIG_FILE, LOCAL_TEST_CONFIG_FILE,
                SERVER_CONFIG_FILE, SERVER_TEST_CONFIG_FILE
        });
    }

    /**
     * 通过指定配置文件启动 undertowServer
     * 无特殊情况，建议使用默认方式启动
     * @param clazz 配置类
     * @param configFile 配置文件
     */
    public static void run(Class<? extends JFinalConfig> clazz, String configFile) {
        run(clazz, new String[]{configFile});
    }

    /**
     * 通过第一个可用的配置文件启动 undertowServer
     * 无特殊情况，建议使用默认方式启动
     * @param clazz 配置类
     * @param configFiles 所有可能的配置文件
     */
    public static void run(Class<? extends JFinalConfig> clazz, String[] configFiles) {
        String configFile = ResourcesUtil.getFirstUsed(configFiles);
        if(null == configFile){
            System.out.println("[error] no config file can be use");
            return;
        }
        System.out.println("[server] use config: " + configFile);
        UndertowServer.create(clazz, configFile).start();
    }
}
