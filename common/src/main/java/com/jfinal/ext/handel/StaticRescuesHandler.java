package com.jfinal.ext.handel;

import com.jfinal.ext.kit.JFinalKit;
import com.jfinal.ext.util.Console;
import com.jfinal.ext.util.MyUtil;
import com.jfinal.handler.Handler;
import com.jfinal.kit.StrKit;
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
    private final String absoluteUploadPath;
    private final String UPLOAD_START;
    private final int UPLOAD_START_LENGTH;

    public StaticRescuesHandler() {
        this("/upload/");
    }

    public StaticRescuesHandler(String relativePath) {
        if(StrKit.isBlank(relativePath.trim())){
            throw new RuntimeException("relativePath（" + relativePath + "）不能为空！");
        }

        this.UPLOAD_START = relativePath;
        this.UPLOAD_START_LENGTH = UPLOAD_START.length();
        absoluteUploadPath = JFinalKit.getConstants().getBaseUploadPath();
    }

    @Override
    public void handle(String target, HttpServletRequest request, HttpServletResponse response, boolean[] isHandled) {
        if(target.startsWith(UPLOAD_START) && target.contains(".")){
            String fileName = absoluteUploadPath + target.substring(UPLOAD_START_LENGTH - 1);
            File file = new File(fileName = MyUtil.formatPath(fileName));
            Console.info("[StaticRescuesHandler] " + target + " --> " + fileName);
            if(file.exists() && file.canRead()){
                try {
                    IOUtils.copy(new FileInputStream(file), response.getOutputStream());
                } catch (IOException ignored) {
                    // 不做处理，系统会自动返回404
                }
                isHandled[0] = true;
            }
        }
        next.handle(target, request, response, isHandled);
    }

}
