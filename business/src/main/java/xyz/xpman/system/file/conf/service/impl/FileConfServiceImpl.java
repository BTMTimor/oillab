package xyz.xpman.system.file.conf.service.impl;


import com.jfinal.ext.common.service.impl.BaseServiceImpl;
import xyz.xpman.system.file.conf.model.FileConf;
import xyz.xpman.system.file.conf.service.FileConfService;

public class FileConfServiceImpl extends BaseServiceImpl<FileConf> implements FileConfService {
    private static final String SQL_NAMESPACE = "file_conf";

    @Override
    public String getNamespace() { return SQL_NAMESPACE;}

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - -


}