package com.jfinal.ext.annotation.service;

import com.jfinal.ext.annotation.TableColDesc;
import com.jfinal.ext.annotation.TableDesc;
import com.jfinal.kit.Kv;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/*
    author: Timor
    date: 2020/2/20 0020
*/
public class TableService {
    private final AnnotationService ans;

    public TableService() {
        ans = new AnnotationService(new WebNameFormatter());
    }

    /**
     * 获取Table注解的内容，并映射到record中
     * @param clazz 需要获取Table类注解的类
     * @return 注解内容键值对record
     */
    public Kv getTableAnnotation(Class<?> clazz) {
        return ans.getAnnotationToKv(clazz, TableDesc.class);
    }

    /**
     * 获取类成员所有TableCol注解的内容
     * @param clazz 待获取类
     * @return 映射record对象列表
     */
    public List<Kv> getTableColsAnnotation(Class<?> clazz) {
        List<Kv> table_cols_desc = new ArrayList<>();
        if(null != clazz){
            Field[] fields = clazz.getDeclaredFields();
            for(Field field : fields) {
                Kv table_col_dict = getTableColAnnotation(field);
                if(0 != table_col_dict.size()){
                    table_cols_desc.add(table_col_dict);
                }
            }
        }
        return table_cols_desc;
    }

    private Kv getTableColAnnotation(Field field) {
        return ans.getAnnotationToKv(field, TableColDesc.class);
    }
}
