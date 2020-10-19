package xyz.xpman.system.file.manager.controller;

import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.ext.kit.JFinalKit;
import com.jfinal.ext.kit.MyPathKit;
import com.jfinal.ext.util.MyUtil;
import com.jfinal.kit.Ret;
import com.jfinal.kit.StrKit;
import com.jfinal.log.Log;
import com.jfinal.upload.UploadFile;
import org.apache.commons.io.FileUtils;
import org.app.config.CommonConfig;
import xyz.xpman.system.file.info.model.FileInfo;
import xyz.xpman.system.file.info.service.impl.FileInfoServiceImpl;
import xyz.xpman.system.file.manager.service.FileUploadService;
import xyz.xpman.system.file.manager.uitl.RetResult;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

/*
    author: 江理网猿
    date: 2020/10/7 0007
*/
public class FileUploadController extends Controller {
    public static final Log log = Log.getLog(FileUploadController.class);
    private static final SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
    private static final String BASE_UPLOAD_PATH = JFinalKit.getConstants().getBaseUploadPath();
    private static final String[] imageManagerAllowFiles = {".png", ".jpg", ".jpeg", ".gif", ".bmp"};
    private static final String[] fileManagerAllowFiles = {
            // 图片
            ".png", ".jpg", ".jpeg", ".gif", ".bmp",
            // 视频
            ".flv", ".swf", ".mkv", ".avi", ".rm", ".rmvb", ".mpeg", ".mpg",
            // 音频
            ".ogg", ".ogv", ".mov", ".wmv", ".mp4", ".webm", ".mp3", ".wav", ".mid",
            // 压缩包、镜像
            ".rar", ".zip", ".tar", ".gz", ".7z", ".bz2", ".cab", ".iso",
            // 文档
            ".doc", ".docx", ".xls", ".xlsx", ".ppt", ".pptx", ".pdf", ".txt", ".md", ".xml"
    };
    private static final String RESOURCE_PATH = MyPathKit.getWebRootPath();
    private static final Ret failureResult = Ret.create("state", "FAILURE");
    private static final String tempUploadPath = "/temp";
    private static final String baseUploadPath = "/upload";
    private static final String ImageUploadPath = "/images";
    private static final String VideoUploadPath = "/video";
    private static final String FileUploadPath = "/file";
    private static final String SnapScreenUploadPath = "/images";
    private static final String ScrawlUploadPath = "/file";
    private static final String AUploadPath = "/a";

    @Inject private FileInfoServiceImpl fileInfoService;
    @Inject private FileUploadService fileUploadService;

    private String getBaseUploadPath(){
        return JFinalKit.getConstants().getBaseUploadPath();
    }

    private String getTempFilePath(){
        return "";
    }

    /**
     * 上传图片
     */
    public void uploadImage() {
//        uploadFile();
    }

    /**
     * 上传涂鸦图片
     */
    public void uploadScrawl(){
//        uploadFile();
    }

    /**
     * 上传截图
     */
    public void uploadSnapScreen(){
//        uploadFile();
    }

    /**
     * 上传远程抓取图片
     */
    public void uploadCatcherImage(){
        renderText("uploadCatcherImage");
    }

    /**
     * 上传视频
     */
    public void uploadVideo() {
//        uploadFile();
    }

    /**
     * 上传文件
     * */
    public void upFile() {
//        uploadFile();
    }

    /**批量上传文件*/
    public void uploadFiles() {
        Map<String, String[]> parameterMap = getRequest().getParameterMap();
        for (String key : parameterMap.keySet()) {
            System.out.println(key + ":" + Arrays.toString(parameterMap.get(key)));
        }
        renderJson("{status: success, url: /static/oillab/logo.jpg}");
    }


    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    protected FileInfo getFileInfo(UploadFile uploadFile) {
        FileInfo fileInfo = FileInfo.byFile(uploadFile);
        String serverAddress = CommonConfig.getServerAddress();
        if(StrKit.notBlank(serverAddress)){
            fileInfo.setResourceUrl(
                    serverAddress + "/" + fileInfo.getResourceUrl());
        }
        return fileInfo;
    }

    /**
     * 上传文件并处理结果
     * @param uploadFile 上传的文件
     */
    protected void uploadFile(UploadFile uploadFile){
        renderJson(fileUploadService.upload(getFileInfo(uploadFile)));
    }

    protected void uploadFile(UploadFile uploadFile, String config, String businessType){
        FileInfo fileInfo = getFileInfo(uploadFile);
        fileInfo.setConfig(config);
        fileInfo.setBusinessType(businessType);
        renderJson(fileUploadService.upload(fileInfo));
    }

    protected UploadFile getUploadFile(){
        return getFile();
    }

    protected UploadFile getUploadFile(String paraName){
        return getUploadFile(paraName, getTempFilePath());
    }

    protected UploadFile getUploadFile(String paraName, String tempFilePath){
        return getFile(paraName, tempFilePath);
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    protected void imageManager(String pubDir, Integer start, Integer size){
        fileManager(pubDir, start, size, imageManagerAllowFiles);
    }

    protected void fileManager(String pubDir, Integer start, Integer size){
        fileManager(pubDir, start, size, fileManagerAllowFiles);
    }

    protected void fileManager(String pubDir, Integer start, Integer size, String[] extensions){
        File dir = new File(pubDir);
        if (!dir.exists()) {
            renderJson(RetResult.failure("文件夹不存在"));
        } else if (!dir.isDirectory()) {
            renderJson(RetResult.failure("该文件不是文件夹"));
        } else {
            fileManager(listFiles(pubDir, extensions), start, size);
        }
    }

    protected void fileManager(List<String> pubDir, Integer start, Integer size, String[] extensions){
        fileManager(listFiles(pubDir, extensions), start, size);
    }

    protected void fileManager(List<File> files, Integer start, Integer size){
        if (start < 0 || start > files.size()) {
            renderJson(RetResult.failure(""));
        } else {
            // list: [{url: xxxUrl}, {url: xxxUrl}]
            int count = (start + size < files.size()) ? size : files.size() - start;
            List<Ret> fileList = new ArrayList<>((8 * count) / 5);
            for (int i = start; i < count; i++) {
                String url = files.get(i).getAbsolutePath()
                        .replace(getBaseUploadPath(), "");
                fileList.add(Ret.by("url", MyUtil.formatUrl(url)));
            }

            renderJson(RetResult.success()
                    .set("start", start)
                    .set("total", fileList.size())
                    .set("list", fileList)
            );
        }
    }

    // pubDir为相对路径
    protected List<File> listFiles(String pubDir, final String[] extensions){
        return listFiles(Collections.singletonList(pubDir), extensions);
    }

    // pubDir为相对路径, 若文件夹不存在或不是是文件夹：打印日志，跳过该文件
    protected List<File> listFiles(List<String> pubDir, final String[] extensions){
        List<File> fileList = new ArrayList<>();
        for (String dir : pubDir) {
            dir = MyUtil.formatPath(getBaseUploadPath() + "/" + dir);
            File directory = new File(dir);
            if (!directory.exists()) {
                log.warn("文件夹不存在: %s", dir);
            } else if (!directory.isDirectory()) {
                log.warn("该文件不是文件夹: %s", dir);
            } else {
                fileList.addAll(FileUtils.listFiles(directory, extensions, true));
            }
        }
        return fileList;
    }

    // pubDir为相对路径
    /*protected List<File> listFiles(File dir, final String[] extensions){
        return listFiles(Collections.singletonList(new File(dir)), extensions);
    }*/

    // pubDir为相对路径
    /*protected List<File> listFiles(List<File> dirs, final String[] extensions){
        List<File> fileList = new ArrayList<>();
        for (File dir : dirs) {
            fileList.addAll(FileUtils.listFiles(dir, extensions, true));
        }
        return fileList;
    }*/


    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    private String getFormatDate(){
        return dataFormat.format(new Date());
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    private void printUploadFileInfo(UploadFile upFile){
        String sb = "upFile{"
                + "FileName: " + upFile.getFileName() + ", "
                + "UploadPath: " + upFile.getUploadPath() + ", "
                + "ContentType: " + upFile.getContentType() + ", "
                + "OriginalFileName: " + upFile.getOriginalFileName() + ", "
                + "ParameterName: " + upFile.getParameterName() + ", "
                + "}";
        System.out.println(sb);
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

}
