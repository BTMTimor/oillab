package xyz.xpman.system.file.info.model;

import com.common.base.model.generate.BaseFileInfo;
import com.jfinal.ext.annotation.TableBind;
import com.jfinal.ext.util.MyUtil;
import com.jfinal.ext.util.file.FileHashUtil;
import com.jfinal.ext.util.file.MyFileUtil;
import com.jfinal.kit.FileKit;
import com.jfinal.kit.StrKit;
import com.jfinal.upload.UploadFile;
import xyz.xpman.system.file.conf.model.FileConf;
import xyz.xpman.system.file.conf.service.FileConfService;
import xyz.xpman.system.file.conf.service.impl.FileConfServiceImpl;
import xyz.xpman.system.file.manager.uitl.MimeUtil;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * author: Timor
 * date: 2020-9-10
 *  description: …… */
@TableBind(tableName = "file_info", primaryKey = "id")
public class FileInfo extends BaseFileInfo<FileInfo> {
    private static final SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final FileConfService fileConfService = new FileConfServiceImpl();
    public static final Integer COMMON_HIDDEN = 0;
    public static final Integer COMMON_STATUS = 1;
    public static final Integer COMMON_DELETE = 8;
    public static final Integer COMMON_FAKE_DELETE = 9;
    public static final Integer COMMON_ERROR = 16;
    private String message = null;
    private File file = null;

    public FileInfo() {
        this.setId(StrKit.getRandomUUID());
    }

    private FileInfo(File file){
        this.file = file;
        // 自动填充字段
        this.setId(StrKit.getRandomUUID());
        this.setFileType(FileKit.getFileExtension(file));
        this.setNewName(getId() + "." + getFileType());
        this.setOriginalName(file.getName());
        this.setFileSize(Long.valueOf(file.length() / 1024).intValue());
        try {
            this.setHash(FileHashUtil.hash(file));
        } catch (IOException ignored) {}
        this.setCreatTime(new Date());
        this.setUpdateTime(new Date());
        this.setStatus(COMMON_STATUS);
    }

    public static FileInfo byFile(UploadFile uploadFile) {
        FileInfo fileInfo = new FileInfo(uploadFile.getFile());
        fileInfo.setContentType(uploadFile.getContentType());
        return fileInfo;
    }

    // 请通过getMessage获取失败信息
    public boolean simpleCheck() {
        message = check();
        return StrKit.isBlank(message);
    }

    public String process() {
        // 重命名文件
        if (!MyFileUtil.renameFile(this.file, this.getAbsolutePath())) {
            return "无操作文件权限";
        }
        return "";
    }

    public String checkAndProcess() {
        String message;
        if (StrKit.notBlank((message = check()), ((message = process())))) {
            return message;
        }
        return "";
    }

    public String check() {
        FileConf fileConf = fileConfService.findById(this.getConfig());
        if (null == fileConf) {
            return "配置不存在：" + this.getConfig();
        }

        // 校验是否限制文件大小及文件大小符合限制
        Integer fileSizeLimit = fileConf.getSizeLimit();
        if (0 > fileSizeLimit.compareTo(0)
                && 0 < fileSizeLimit.compareTo(getFileSize())) {
            return "文件大小应小于" + fileSizeLimit + "kb";
        }

        // 校验文件类型
        if (!fileConf.accessType(getFileType())) {
            return "非法文件类型：" + getFileType();
        }

        if(!MimeUtil.checkType(getContentType(), getFileType())){
            return "非法文件类型(" + getContentType() + ": " + getFileType() + ")";
        }

        return "";
    }

    public boolean isAccess(){
        return StrKit.isBlank(message);
    }

    @Override
    public String checkCommonFiled() {
        if(null == getStatus()){setStatus(1);}
        return EMPTY_STRING;
    }

    @Override
    public String checkForAdd() {
        return super.checkForAdd(()->{
            return EMPTY_STRING;
        });
    }

    @Override
    public String checkForUpdate() {
        return super.checkForUpdate(()->{
            this.setUpdateTime(new Date());
            return EMPTY_STRING;
        });
    }




    public void setContentType(String contentType){
        set("contentType", contentType);
    }

    public String getContentType(){
        return get("contentType");
    }

    public File getFile(){
        return this.file;
    }



    @Override
    public void setResourceUrl(String url) {
        super.setResourceUrl(MyUtil.formatUrl(url));
    }

    @Override
    public void setRelativePath(String relativePath) {
        super.setRelativePath(MyUtil.formatPath(relativePath));
    }

    @Override
    public void setAbsolutePath(String filePath) {
        super.setAbsolutePath(MyUtil.formatPath(filePath));
    }

    public String getMessage(){
        return message;
    }

    private static String getFormatDate(){
        return dataFormat.format(new Date());
    }

    public void printInfo(){
        System.out.println("[FileInfo] newFileName: " + this.getNewName());
        System.out.println("[FileInfo] originalName: " + this.getOriginalName());
        System.out.println("[FileInfo] fileSize: " + this.getFileSize() + "kb");
        System.out.println("[FileInfo] fileType: " + this.getFileType());
        System.out.println("[FileInfo] contentType: " + this.getContentType());
        System.out.println("[FileInfo] resourceUrl: " + this.getResourceUrl());
        System.out.println("[FileInfo] relativePath: " + this.getRelativePath());
        System.out.println("[FileInfo] absolutePath: " + this.getAbsolutePath());
        System.out.println("[FileInfo] errorMessage: " + this.getMessage());
    }
}
