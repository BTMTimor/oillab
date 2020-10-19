package com.jfinal.ext.kit;

import com.jfinal.config.*;
import com.jfinal.plugin.IPlugin;

import java.util.ArrayList;
import java.util.List;

/*
    author: Timor
    date: 2020/1/16 0016
*/
public class JFinalKit {

    static {
        init();
    }

    private static List<IPlugin> pluginList;
    private static Constants constants;
    private static Routes routes;
    private static Plugins plugins;
    private static Interceptors interceptors;
    private static Handlers handlers;

    public static void init() {
        Reflect reflect = Reflect.on("com.jfinal.core.Config");
        constants = reflect.get("constants");
        routes = reflect.get("routes");
        plugins = reflect.get("plugins");
        interceptors = reflect.get("interceptors");
        handlers = reflect.get("handlers");
        pluginList = plugins.getPluginList();
    }

    public static Constants getConstants() {
        return JFinalKit.constants;
    }

    public static Routes getRoutes() {
        return JFinalKit.routes;
    }

    public static Plugins getPlugins() {
        return JFinalKit.plugins;
    }

    public static Interceptors getInterceptors() {
        return JFinalKit.interceptors;
    }

    public static Handlers getHandlers() {
        return JFinalKit.handlers;
    }

    public static void stopPlugin(String pluginName) {
        for (IPlugin iPlugin : pluginList) {
            if (iPlugin.getClass().getSimpleName().equals(pluginName)) {
                iPlugin.stop();
            }
        }
    }

    public static List<IPlugin> findPlugin(Class<? extends IPlugin> plugin) {
        return findPlugin(plugin.getSimpleName());
    }

    public static List<IPlugin> findPlugin(String pluginName) {
        List<IPlugin> plugins = new ArrayList<>();
        for (IPlugin iPlugin : pluginList) {
            if (iPlugin.getClass().getSimpleName().equals(pluginName)) {
                plugins.add(iPlugin);
            }
        }
        return plugins;
    }

    public static void startPlugin(String pluginName) {
        for (IPlugin iPlugin : pluginList) {
            if (iPlugin.getClass().getSimpleName().equals(pluginName)) {
                iPlugin.start();
            }
        }
    }

    public static void restartPlugin(String pluginName) {
        for (IPlugin iPlugin : pluginList) {
            if (iPlugin.getClass().getSimpleName().equals(pluginName)) {
                iPlugin.stop();
                iPlugin.start();
            }
        }
    }

}
