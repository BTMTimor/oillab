package com.oillab;

import com.jfinal.ext.starter.ServerStarter;
import com.jfinal.kit.PathKit;
import com.oillab.common.config.AppConfig;

/*
    author: Timor
    date: 2020/1/16 0016
*/
public class Main {

    public static void initPathKit(){
        String temp = PathKit.getRootClassPath();
        System.out.println("RootClassPath: " + temp);
        String GRADLE_MAIN = "build\\classes\\java\\main";
        if(temp.endsWith(GRADLE_MAIN)){
            String GRADLE_WEBAPP = "src\\main\\webapp";
            PathKit.setWebRootPath(temp.replace(GRADLE_MAIN, GRADLE_WEBAPP));
        }
        System.out.println("WebRootPath: " + PathKit.getWebRootPath());
    }

    public static void main(String[] args) {
        initPathKit();
        ServerStarter.run(AppConfig.class);
    }
}
