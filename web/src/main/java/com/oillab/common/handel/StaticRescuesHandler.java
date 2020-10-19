package com.oillab.common.handel;

import com.jfinal.ext.kit.JFinalKit;
import com.jfinal.handler.Handler;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/*
    author: 江理网猿
    date: 2020/9/15 0015
*/
public class StaticRescuesHandler extends Handler {
    private static final String absoluteUploadPath = JFinalKit.getConstants().getBaseUploadPath();
    public static final String UPLOAD_START = "/upload/";
    public static final int UPLOAD_START_LENGTH = UPLOAD_START.length();

    @Override
    public void handle(String target, HttpServletRequest request, HttpServletResponse response, boolean[] isHandled) {
        if(target.contains(".")) {System.out.println("[StaticRescuesHandler] " + target);}
        if(target.startsWith(UPLOAD_START) && target.contains(".")){
            String fileName = absoluteUploadPath + target.substring(UPLOAD_START_LENGTH - 1);
            File file = new File(fileName);
            if(file.exists() && file.canRead() && file.getAbsolutePath().startsWith(absoluteUploadPath)){
                try {
                    IOUtils.copy(new FileInputStream(file), response.getOutputStream());
                    System.out.println("[static] " + target + " : " + fileName);
                    isHandled[0] = true;
                } catch (IOException ignored) {}
            }
        }
        next.handle(target, request, response, isHandled);
    }

}
