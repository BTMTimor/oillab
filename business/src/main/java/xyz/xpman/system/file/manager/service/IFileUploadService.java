package xyz.xpman.system.file.manager.service;

import com.jfinal.kit.Ret;
import xyz.xpman.system.file.info.model.FileInfo;

/*
    author: 江理网猿
    date: 2020/10/7 0007
*/
public interface IFileUploadService {

    Ret upload(FileInfo fileInfo);

}
