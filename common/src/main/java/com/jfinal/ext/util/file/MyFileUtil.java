package com.jfinal.ext.util.file;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jfinal.kit.StrKit;
import com.jfinal.log.Log;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/*
    author: Timor
    date: 2020/3/14 0014
*/
public class MyFileUtil {
    public static Log log = Log.getLog(MyFileUtil.class);

    public static String readFileToString(File file) throws IOException {
        if(file.exists() && file.canRead()){
            return FileUtils.readFileToString(file, String.valueOf(StandardCharsets.UTF_8));//前面两行是读取文件
        }
        log.error("File(%s) not exists or no permission to read.", file.getName());
        return "";
    }

    public static String readFileToString(String fileName) throws IOException {
        return readFileToString(new File(fileName));
    }

    public static JSONObject readFileToJSONObject(File file) throws IOException {
        return JSON.parseObject(readFileToString(file));
    }

    public static JSONObject readFileToJSONObject(String fileName) throws IOException {
        return JSON.parseObject(readFileToString(fileName));
    }

    public static <T> T readFileToJavaObject(File file, Class<T> clazz) throws IOException {
        return JSON.parseObject(readFileToString(file), clazz);
    }

    public static <T> T readFileToJavaObject(String fileName, Class<T> clazz) throws IOException {
        return JSON.parseObject(readFileToString(fileName), clazz);
    }


    /// write

    public static void writeJSONObjectToFile(JSONObject json, String fileName) throws IOException {
        FileUtils.writeStringToFile(new File(fileName),
                json.toJSONString(), String.valueOf(StandardCharsets.UTF_8));
    }

    public static void writeStringToFile(String str, String fileName) throws IOException {
        FileUtils.writeStringToFile(new File(fileName),
                str, String.valueOf(StandardCharsets.UTF_8));
    }

    public static void writeStringToFile(String str, File file) throws IOException {
        FileUtils.writeStringToFile(file, str, String.valueOf(StandardCharsets.UTF_8));
    }


    // copy

    public static void copyFileToFile(File srcFile, File destFile) throws IOException {
        FileUtils.copyFile(srcFile, destFile);
    }

    public static void copyFileToFile(File srcFile, File destFile, boolean preserveFileDate) throws IOException {
        FileUtils.copyFile(srcFile, destFile, preserveFileDate);
    }

    public static void copyFileToDirectory(File srcFile, File destDir) throws IOException {
        FileUtils.copyFileToDirectory(srcFile, destDir);
    }

    public static void copyFileToDirectory(File srcFile, File destDir, boolean preserveFileDate) throws IOException {
        FileUtils.copyFileToDirectory(srcFile, destDir, preserveFileDate);
    }

    /**
     * 重命名文件
     * @param file 预被重命名的文件
     * @param newFileName 新名称
     * @return 是否成功
     */
    public static boolean renameFile(File file, String newFileName){
        if(null == file || StrKit.isBlank(newFileName)){ return false;}
        System.out.println("[rename] " + file.getName() + " --> " + newFileName);
        try {
            File newFile = new File(newFileName);
            if(newFile.getParentFile().mkdirs()){
                return file.renameTo(newFile);
            }
        }catch (Exception ignored){ }
        return false;
    }

}
