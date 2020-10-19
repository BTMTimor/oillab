package com.jfinal.ext.plugin.route;

import com.jfinal.config.Routes;
import com.jfinal.core.Controller;
import com.jfinal.ext.annotation.RequestMapping;
import com.jfinal.ext.util.Console;
import com.jfinal.kit.StrKit;
import com.jfinal.log.Log;

import java.util.*;

/*
    author: Timor
    date: 2020/7/14 0014
*/
public class AutoBindRequestKit {
    protected final Log logger = Log.getLog(getClass());
    // 排除的controller
    private final List<Class<? extends Controller>> excludeClasses = new ArrayList<>();

    public AutoBindRequestKit() {}

    public void bind(Routes routes, Set<Class<?>> controllerClassSet) {
        if (controllerClassSet.isEmpty()) {
            Console.info("RequestMapping: no controller found.");
            return;
        }

        controllerClassSet.removeAll(excludeClasses);
        for (Class<?> clazz : controllerClassSet) {
            RequestMapping meta = clazz.getAnnotation(RequestMapping.class);
            if (StrKit.notBlank(meta.value())) {
                Console.info("RequestMapping(%s : %s)", meta.value(), clazz.getName());
                routes.add(meta.value(), (Class<? extends Controller>) clazz, meta.viewPath());
            }
        }
    }


    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @SuppressWarnings("unchecked")
    public AutoBindRequestKit addExcludeClasses(Class<? extends Controller>... classes) {
        if (classes != null) {
            excludeClasses.addAll(Arrays.asList(classes));
        }
        return this;
    }

    public AutoBindRequestKit addExcludeClasses(List<Class<? extends Controller>> classes) {
        excludeClasses.addAll(classes);
        return this;
    }

}
