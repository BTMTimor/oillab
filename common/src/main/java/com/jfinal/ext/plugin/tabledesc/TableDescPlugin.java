package com.jfinal.ext.plugin.tabledesc;

import com.jfinal.ext.util.clazz.scan.ClassScanner;
import com.jfinal.kit.Kv;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.IPlugin;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.ext.annotation.TableDesc;
import com.jfinal.ext.annotation.service.TableService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    author: 江理网猿
    date: 2020/7/24 0024
*/
public class TableDescPlugin implements IPlugin {
    private static final Map<Class<?>, Kv> tableDescCache = new HashMap<>();
    private static final TableService tableService = new TableService();
    public static boolean devMod = false;
    public static boolean start = false;

    @Override
    public boolean start() {
        scanTableDesc();
        start = true;
        return true;
    }

    private void scanTableDesc(){
        List<Class<Model>> tableList = ClassScanner.scanSubClass(Model.class,true, true);
        if (tableList != null) {
            for (Class<?> clazz : tableList) {
                TableDesc meta = clazz.getAnnotation(TableDesc.class);
                if (null != meta && StrKit.notBlank(meta.remark())) {
                    parseTableMeta(clazz);
                }
            }
        }
    }

    private static void parseTableMeta(Class<?> clazz){
        Kv tableDesc = tableService.getTableAnnotation(clazz);
        List<Kv> tableColsDesc = tableService.getTableColsAnnotation(clazz);

        Kv tableMeta = new Kv()
                .set("table", tableDesc)
                .set("cols", tableColsDesc);
        if(!devMod) tableDescCache.put(clazz, tableMeta);
    }

    /**
     * 列表页预处理，获取表格元信息并设置到attribute
     * @param clazz model元对象
     * @return 表格元数据
     */
    public static Kv getTableMeta(Class<?> clazz){
        // 不是开发模式且有缓存
        if(!devMod && tableDescCache.containsKey(clazz)){
            return tableDescCache.get(clazz);
        }else {
            parseTableMeta(clazz);
            return tableDescCache.get(clazz);
        }
    }

    @Override
    public boolean stop() {
        start = false;
        return true;
    }
}
