package com.jfinal.ext.util.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*
    author: 江理网猿
    date: 2020/10/7 0007
*/
public class FileHashUtil {
    public static final String ALGORITHM_MD5 = "MD5";
    private static final FileHashUtil main = new FileHashUtil();
    private FileHash fileHash;

    public FileHashUtil() {
        try {
            fileHash = new FileHash(MessageDigest.getInstance(ALGORITHM_MD5));
        } catch (NoSuchAlgorithmException ignored) { }
    }

    public FileHashUtil(String algorithm) throws NoSuchAlgorithmException {
        fileHash = new FileHash(MessageDigest.getInstance(algorithm));
    }

    /*public static MessageDigest use(String name){
        if("__main__".equals(name)){
            return messageDigest;
        }
        return null;
    }*/


    public static String hash(File file) throws IOException {
        return main.fileHash.hash(file);
    }

    public static String hash(InputStream inputStream) throws IOException {
        return main.fileHash.hash(inputStream);
    }


    static class FileHash{
        private final MessageDigest messageDigest;

        FileHash(MessageDigest messageDigest) {
            this.messageDigest = messageDigest;
        }

        // 获取文件的MD5值
        public String hash(File file) throws IOException {
            return hash(new FileInputStream(file));
        }

        // 获取文件的MD5值
        public String hash(InputStream inputStream) throws IOException {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer, 0, 1024)) > 0) {
                messageDigest.update(buffer, 0, length);
            }
            inputStream.close();
            return new BigInteger(1, messageDigest.digest()).toString(16);
        }

    }


}
