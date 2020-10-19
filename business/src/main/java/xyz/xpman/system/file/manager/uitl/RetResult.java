package xyz.xpman.system.file.manager.uitl;

import com.jfinal.kit.Ret;
import xyz.xpman.system.file.info.model.FileInfo;

import java.util.Date;

/*
    author: 江理网猿
    date: 2020/10/8 0008
*/
public class RetResult extends Ret{
    public static final String FAILURE = "FAILURE";
    public static final String SUCCESS = "SUCCESS";

    public static final String STATE = "state";
    public static final String TITLE = "title";
    public static final String ORIGINAL = "original";
    public static final String TYPE = "type";
    public static final String SIZE = "size";
    public static final String URL = "url";
    public static final String LAST_MODIFIED = "lastModified";
    public static final String PATH = "path";
    private static final String MESSAGE = "message";

    public RetResult() {
        this.set("timestamp", System.currentTimeMillis());
    }

    public static RetResult failure() {
        return new RetResult().setState(FAILURE);
    }

    public static RetResult failure(String message) {
        return new RetResult().setState(FAILURE).setMessage(message);
    }

    public static RetResult success() {
        return new RetResult().setState(SUCCESS);
    }

    public static RetResult success(FileInfo fileInfo) {
        return RetResult.success()
                .setTitle(fileInfo.getNewName())
                .setOriginal(fileInfo.getOriginalName())
                .setType(fileInfo.getFileType())
                .setSize(fileInfo.getFileSize())
                .setUrl(fileInfo.getResourceUrl())
                .setPath(fileInfo.getRelativePath())
                .setLastModified(fileInfo.getUpdateTime())
            ;
    }

    @Override
    public RetResult set(Object key, Object value) {
        super.set(key, value);
        return this;
    }

    public String getState(){
        return getStr(STATE);
    }

    public RetResult setState(String state){
        set(STATE, state);
        return this;
    }

    public String getTitle(){
        return getStr(TITLE);
    }

    public RetResult setTitle(String title){
        set(TITLE, title);
        return this;
    }

    public String getOriginal(){
        return getStr(ORIGINAL);
    }

    public RetResult setOriginal(String original){
        set(ORIGINAL, original);
        return this;
    }

    public String getType(){
        return getStr(TYPE);
    }

    public RetResult setType(String type){
        set(TYPE, type);
        return this;
    }

    public Integer getSize(){
        return getInt(SIZE);
    }

    public RetResult setSize(Integer size){
        set(SIZE, size);
        return this;
    }

    public String getUrl(){
        return getStr(URL);
    }

    public RetResult setUrl(String url){
        set(URL, url);
        return this;
    }

    public Date getLastModified(){
        return (Date) get(LAST_MODIFIED);
    }

    public RetResult setLastModified(Date lastModified){
        set(LAST_MODIFIED, lastModified);
        return this;
    }

    public String getPath(){
        return getStr(PATH);
    }

    public RetResult setPath(String path){
        set(PATH, path);
        return this;
    }

    public String getMessage(){
        return getStr(MESSAGE);
    }

    public RetResult setMessage(String message){
        set(MESSAGE, message);
        return this;
    }

}
