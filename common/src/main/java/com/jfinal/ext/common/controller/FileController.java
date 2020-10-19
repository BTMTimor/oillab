package com.jfinal.ext.common.controller;

import com.jfinal.core.Controller;
import com.jfinal.upload.UploadFile;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/*
    author: Timor
    date: 2019/12/25 0025
*/
public class FileController extends Controller {
    public void index(){
        renderJson("[file/index] nothing here.");
    }
    public void upload() throws UnsupportedEncodingException {
        HttpServletRequest request = getRequest();
//        request.setCharacterEncoding( "utf-8" );
//        getResponse().setHeader("Content-Type" , "text/html");

        String rootPath = request.getServletContext().getRealPath("/");

        System.out.println(rootPath);
//        render(new ActionEnter(request, rootPath ).exec());
        System.out.println("end...");
    }

    public void download(){
        renderJson("nothing here.");
    }

    public void upload1() {
        // 百度编辑器加载出按钮图标前 会将所有控件的路径 先通过config.json
        // 文件加载出来(包括上传图片路径，视频路径等路径都是通过config.json 文件读取的)
        // 所以某些控件点击不了 是因为 config.json文件没有找到 或者是文件里面的路径有问题
        if ("config".equals(getPara("action"))) {
            // 这里千万注意 "config.json" 文件前方的目录一定要正确
            render("/ueditor/config.json");//这里地址写成自己的config.json所在的地址
            return;
        }
        // "upfile" 来自 config.json 中的 imageFieldName 配置项
        UploadFile uf = getFile("upfile");
        String fileName = uf.getFileName();
        String[] typeArr = fileName.split("\\.");
        renderJson("ok");
    }
}
