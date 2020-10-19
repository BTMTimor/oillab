package com.oillab.article.article.model;

import com.common.base.model.generate.BaseArticle;
import com.jfinal.ext.annotation.TableBind;
import com.jfinal.ext.annotation.TableColDesc;
import com.jfinal.ext.annotation.TableDesc;

import java.util.Date;

@SuppressWarnings("serial")
@TableBind(tableName = "article", primaryKey = "id")
@TableDesc(label = "文章", width = "100%", height = "675px")
public class Article extends BaseArticle<Article> {
    private static final String BASE_URL = "/article";

    @TableColDesc(name = "id", paraName = "id", label = "id", show = false)
    public static final String ID = "id";
    public static final String MID = "mid";
    @TableColDesc(name = "modularTitle", paraName = "modularTitle", label = "栏目")
    public static final String MODULAR_NAME = "modularTitle";
    @TableColDesc(name = "uid", paraName = "uid", label = "用户id", show = false)
    public static final String UID = "uid";
    public static final String TYPE = "type";
    @TableColDesc(name = "typeTitle", paraName = "typeTitle", label = "类型")
    public static final String TYPE_NAME = "typeTitle";

    @TableColDesc(name = "views", paraName = "views", label = "阅读数", type = "number", show = false)
    public static final String VIEWS = "views";
    @TableColDesc(name = "title", paraName = "title", label = "文章标题")
    public static final String TITLE = "title";
    @TableColDesc(name = "author", paraName = "author", label = "文章作者")
    public static final String AUTHOR = "author";
    @TableColDesc(name = "description", paraName = "description", label = "文章概要", show = false)
    public static final String DESCRIBES = "description";
    @TableColDesc(name = "coverImg", paraName = "coverImg", label = "引导图", format = "imgFmt")
    public static final String IMG_URL = "coverImg";
    @TableColDesc(name = "content", paraName = "content", label = "文章内容", show = false)
    public static final String CONTENT = "content";
    @TableColDesc(name = "addTime", paraName = "addTime", label = "添加时间", type = "date", show = false)
    public static final String ADD_TIME = "addTime";
    @TableColDesc(name = "pubTime", paraName = "pubTime", label = "发布时间", type = "date", show = false)
    public static final String PUB_TIME = "pubTime";
    @TableColDesc(name = "lastEditTime", paraName = "lastEditTime", label = "最后编辑时间", type = "date")
    public static final String LAST_EDIT_TIME = "lastEditTime";
    @TableColDesc(name = "status", paraName = "status", label = "状态", type = "number", format = "statusFmt")
    public static final String STATUS = "status";


    public void setStatus(Status status) {
        super.setStatus(status.getStatus());
    }

    public enum Status{
        FORBIDDEN(-1), WAITING_FOR_CHECK(0), NORMAL(1), DELETE(2);

        private final int status;

        Status(int status) {
            this.status = status;
        }

        public int getStatus() {
            return status;
        }
    }

    public String getUrl(){
        return BASE_URL + "/" + getId();
    }

    public String getModularTitle() {
        return getStr("modularTitle");
    }

    public void setModularTitle(String modularTitle) {
        set("modularTitle", modularTitle);
    }

    public String getTypeTitle() {
        return getStr("typeTitle");
    }

    public void setTypeTitle(String typeTitle) {
        set("typeTitle", typeTitle);
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -


    @Override
    public String checkCommonFiled() {
        if((null == this.getPubTime())){this.setPubTime(new Date());}

        return super.checkCommonFiled();
    }

    @Override
    public String checkForUpdate() {
        this.setLastEditTime(new Date());
        return super.checkForUpdate();
    }

    @Override
    public String checkForAdd() {
        this.setAddTime(new Date());
        this.setLastEditTime(new Date());
        return super.checkForAdd();
    }
}
