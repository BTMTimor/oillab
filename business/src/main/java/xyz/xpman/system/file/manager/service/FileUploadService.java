package xyz.xpman.system.file.manager.service;

import com.jfinal.aop.Inject;
import com.jfinal.kit.Ret;
import com.jfinal.kit.StrKit;
import xyz.xpman.system.file.conf.service.FileConfService;
import xyz.xpman.system.file.conf.service.impl.FileConfServiceImpl;
import xyz.xpman.system.file.info.model.FileInfo;
import xyz.xpman.system.file.info.service.FileInfoService;
import xyz.xpman.system.file.info.service.impl.FileInfoServiceImpl;
import xyz.xpman.system.file.manager.uitl.RetResult;

import java.text.SimpleDateFormat;

/*
    author: 江理网猿
    date: 2020/10/7 0007
*/
public class FileUploadService implements IFileUploadService{
    public static final SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static final Ret failureResult = Ret.create("state", "FAILURE");

    @Inject(FileConfServiceImpl.class)
    private FileConfService fileConfService;
    @Inject(FileInfoServiceImpl.class)
    private FileInfoService fileInfoService;

    // 暂时不支持上传到cdn等
    @Override
    public RetResult upload(FileInfo fileInfo){
        String message = fileInfo.check();
        // 校验文件是否ok
        if (StrKit.notBlank(message)) {
            return RetResult.failure(message);
        }

        // 添加数据库记录
        // 成功：将文件重命名至数据库名称（failure：set status=error）
        // 失败，将文件删除 todo
        if(fileInfoService.add(fileInfo)){
            // 重命名等操作，若失败则将文件状态改为error
            if(StrKit.notBlank(message = fileInfo.process())){
                fileInfo.setStatus(FileInfo.COMMON_ERROR);
                fileInfoService.update(fileInfo);
                return RetResult.failure(message);
            }else{
                return RetResult.success(fileInfo);
            }
        }else{
            // 失败，将文件删除 todo
            boolean deleteFileResult = fileInfo.getFile().delete();
            message = "添加文件记录失败，删除文件：" + deleteFileResult;
            return RetResult.failure(message);
        }
    }


}
