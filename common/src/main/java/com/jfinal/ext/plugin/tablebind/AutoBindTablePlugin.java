package com.jfinal.ext.plugin.tablebind;

import com.jfinal.core.Controller;
import com.jfinal.ext.annotation.TableBind;
import com.jfinal.ext.util.Console;
import com.jfinal.kit.StrKit;
import com.jfinal.plugin.IPlugin;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/*
    author: Timor
    date: 2020/7/14 0014
*/
public class AutoBindTablePlugin implements IPlugin {
    private final Set<Class<?>> modelClassSet;
    private final ActiveRecordPlugin arp;
    private final boolean showInfo;
    // 排除的controller
    private final List<Class<? extends Controller>> excludeClasses = new ArrayList<>();

    public AutoBindTablePlugin(ActiveRecordPlugin arp, Set<Class<?>> modelClassSet) {
        this(arp, modelClassSet, false);
    }

    public AutoBindTablePlugin(ActiveRecordPlugin arp, Set<Class<?>> modelClassSet, boolean showInfo) {
        if(null == arp){
            throw new RuntimeException("arp can't be null.");
        }
        this.arp = arp;
        this.showInfo = showInfo;
        this.modelClassSet = modelClassSet;
    }

    @Override
    public boolean start() {
        bindTable();
        return true;
    }

    @SuppressWarnings("unchecked")
    public void bindTable(){
        if (modelClassSet.isEmpty()) {
            System.out.println("[TableMapping] no model found.");

        }

        modelClassSet.removeAll(excludeClasses);
        for (Class<?> clazz : modelClassSet) {
            TableBind meta = clazz.getAnnotation(TableBind.class);
            if (StrKit.notBlank(meta.tableName())) {
                if(this.showInfo) {
                    Console.log("TableMapping: %s(%s : %s)",
                            clazz.getName(), meta.tableName(), meta.primaryKey());
                }
                arp.addMapping(meta.tableName(), meta.primaryKey(),
                        (Class<? extends Model<?>>) clazz);
            }
        }
    }

    @Override
    public boolean stop() {
        return true;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @SuppressWarnings("unchecked")
    public AutoBindTablePlugin addExcludeClasses(Class<? extends Controller>... classes) {
        if (classes != null) {
            excludeClasses.addAll(Arrays.asList(classes));
        }
        return this;
    }

    public AutoBindTablePlugin addExcludeClasses(List<Class<? extends Controller>> classes) {
        excludeClasses.addAll(classes);
        return this;
    }

}
