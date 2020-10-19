package xyz.xpman.system.file.manager;

import com.jfinal.ext.util.file.FileHashUtil;

import java.io.File;
import java.io.IOException;

/*
    author: 江理网猿
    date: 2020/7/25 0025
*/
public class FileController {

    public void test() throws IOException {
        FileHashUtil.hash(new File("D:\\projectData\\yudu-museum\\upload\\temp\\2e37b7145a52f8d745daff3ca735123b.mp4"));
    }
}
