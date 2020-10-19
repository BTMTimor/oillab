package xyz.xpman.system.file.ueditor;

import com.jfinal.aop.Inject;
import com.jfinal.ext.annotation.RequestMapping;
import com.jfinal.ext.common.controller.BaseController;
import com.jfinal.ext.kit.MyPathKit;
import com.jfinal.kit.FileKit;
import com.jfinal.kit.Ret;
import com.jfinal.kit.StrKit;
import com.jfinal.upload.UploadFile;
import xyz.xpman.system.file.info.model.FileInfo;
import xyz.xpman.system.file.info.service.impl.FileInfoServiceImpl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/*
    author: Timor
    date: 2020/1/11 0011
*/
@RequestMapping("/ueditor")
public class UEditorController extends BaseController {
    private static final String CONFIG_FILE = "/config/editor/ueditor.conf";
    private static final String RESOURCE_PATH = MyPathKit.getWebRootPath();
    private static final String tempUploadPath = "/temp";
    private static final String baseUploadPath = "/upload";
    private static final String ImageUploadPath = "/images";
    private static final String VideoUploadPath = "/video";
    private static final String FileUploadPath = "/file";
    private static final String SnapScreenUploadPath = "/images";
    private static final String ScrawlUploadPath = "/file";
    private static final String AUploadPath = "/a";
    public static final SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Inject
    FileInfoServiceImpl fileInfoService;


    /**
     * 上传图片
     */
    public void upImage() {
        UploadFile upFile = getUpFile();
        //check file
        renderJson(this.processFile(upFile, ImageUploadPath));
    }

    /**
     * 上传涂鸦图片
     */
    public void upScrawl(){
        UploadFile upFile = getUpFile();
        //check file
        renderJson(this.processFile(upFile, ScrawlUploadPath));
    }

    /**
     * 上传截图
     */
    public void upSnapScreen(){
        UploadFile upFile = getUpFile();
        //check file
        renderJson(this.processFile(upFile, SnapScreenUploadPath));
    }

    /**
     * 上传远程抓取图片
     */
    public void upCatcherImage(){
        renderText("uploadCatcherImage");
    }

    /**
     * 上传视频
     */
    public void upVideo() {
        UploadFile upFile = getUpFile();
        //check file
        renderJson(this.processFile(upFile, VideoUploadPath));
    }

    /**
     * 上传文件
     * */
    public void upFile() {
        UploadFile upFile = getUpFile();
        //check file
        renderJson(this.processFile(upFile, FileUploadPath));
    }

    /**
     * 上传文件
     * */
    /*public void upFile2() {
        renderJson(processFile());
    }*/

    /**批量上传文件*/
    public void upFiles() {
        Map<String, String[]> parameterMap = getRequest().getParameterMap();
        for (String key : parameterMap.keySet()) {
            System.out.println(key + ":" + Arrays.toString(parameterMap.get(key)));
        }

        System.out.println(getRequest().getContentLength());
//        System.out.println(getRawData());
        System.out.println(getFile());


        renderJson("{status: success, url: /static/oillab/logo.jpg}");
    }

    private Ret processFile() {
        UploadFile upFile = getFile();
        System.out.println(upFile.getFileName());
        return processFile(upFile, "", upFile.getFileName());
    }

    private Ret processFile(String uploadPath) {
        return processFile(getUpFile(), uploadPath, getTempFileName());
    }

    private Ret processFile(UploadFile uploadFile, String uploadPath) {
        return processFile(uploadFile, uploadPath, getTempFileName());
    }

    /**
     * 处理文件储存
     * @param upload 上传的文件
     * @param uploadPath 上传到的文件路径
     * @param newFileName 保存文件名称
     * @return 处理结果（返回给ueditor）
     */
    private Ret processFile(UploadFile upload, String uploadPath, String newFileName){
        if (null == upload){
            throw new NullPointerException("UploadFile can not be null.");
        }
        printUploadFileInfo(upload);

        if(null == uploadPath) { uploadPath = ""; }
        // 文件均保存到当前日期的文件夹内
        uploadPath += "/" + getFormatDate();

        Ret ret = null;
        try {
            // 获取文件名
            String fileName = upload.getFileName();
            //重命名原来的文件
            File file = upload.getFile();
            long fileSize = file.length();
            String filePath = formatPath(baseUploadPath + "/" + uploadPath);
            newFileName = formatPath(filePath + "/" + newFileName);
            String serverAddress = getAttr("ctx", "");

            // todo
            FileInfo fileInfo = new FileInfo();
            fileInfo.setFileType(FileKit.getFileExtension(file));
            fileInfo.setCreatTime(new Date());
            fileInfo.setUpdateTime(new Date());
            fileInfo.setOriginalName(file.getName());
//            fileInfo.setl
//            fileInfo.setNewName();

//            fileInfoService.add();

            System.out.println("[processFile] fileName: " + fileName);
            System.out.println("[processFile] uploadPath: " + uploadPath);
            System.out.println("[processFile] newFileName: " + newFileName);
            System.out.println("[processFile] serverAddress: " + serverAddress);



            if(!newFileName.contains(".")) {newFileName += getFileExtension(file);}
            boolean result = this.renameFile(file, newFileName);
            if (!result) {
                return Ret.create("state", "FAILURE");
            }

            //重新组合文件路径  ip+文件目录+文件名
            String fileUrl = serverAddress + formatUrl("/" + newFileName);
            System.out.println("[processFile] newFileUrl: " + fileUrl);
            String lastModified = "" + new Date(file.lastModified()).toString();

            ret = Ret.create("state", "SUCCESS")
                .set("name", fileName)
                .set("type", "." + upload.getContentType().split("/")[1])
                .set("size", fileSize)
                .set("url", fileUrl)
                .set("lastModified", lastModified)
                // .set("path",filePath)
                .set("original", upload.getOriginalFileName());
        } catch (Exception e) {
            ret = Ret.create("state", "FAILURE");
            e.printStackTrace();
        }
        System.out.println(ret);
        return ret;
    }

    /**
     * 重命名文件
     * @param file 预被重命名的文件
     * @param newFileName 新名称
     * @return 是否成功
     */
    private boolean renameFile(File file, String newFileName){
        boolean result;
        if(!newFileName.contains(":")) {newFileName = formatPath(RESOURCE_PATH + newFileName);}
        System.out.println("[rename] " + file.getName() + " --> " + newFileName);
        try {
            File newFile = new File(newFileName);
            newFile.getParentFile().mkdirs();
            result = file.renameTo(newFile);
        }catch (Exception e){
            result = false;
        }
        return result;
    }

    public void imageManager(){
        renderText("");
    }

    public void fileManager(){
        renderText("");
    }


    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // 文件统一上传到临时目录
    private UploadFile getUpFile(){
        return getUpFile("upFile");
    }

    private UploadFile getUpFile(String paraName){
        // 文件统一上传到临时目录
        return getFile(paraName, tempUploadPath);
    }

    private String getTempFileName(){
        return StrKit.getRandomUUID();
    }

    private String getFormatDate(){
        return dataFormat.format(new Date());
    }

    private String formatUrl(String url){
        final String urlSeparator = "/";
        url = url.replace("\\", urlSeparator);
        url = url.replace("\\\\", urlSeparator);
        url = url.replace("\\/", urlSeparator);
        url = url.replace("//", urlSeparator);
        return url;
    }

    private String formatPath(String path){
        path = path.replace("//", File.separator);
        path = path.replace("/", File.separator);
        path = path.replace("\\", File.separator);
        path = path.replace("\\\\", File.separator);
        path = path.replace("\\/", File.separator);
        return path;
    }

    private String getFileExtension(File file){
        return "." + FileKit.getFileExtension(file);
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

    // ueditor上传
    public void config(){
        render(CONFIG_FILE);
    }

}
