package xyz.xpman.system.file.info.service.impl;

import com.jfinal.ext.common.service.impl.BaseServiceImpl;
import xyz.xpman.system.file.info.model.FileInfo;
import xyz.xpman.system.file.info.service.FileInfoService;

public class FileInfoServiceImpl extends BaseServiceImpl<FileInfo> implements FileInfoService {
    private static final String SQL_NAMESPACE = "file_info";

    @Override
    public String getNamespace() { return SQL_NAMESPACE;}

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -


}