package com.jfinal.ext.kit;


import com.jfinal.ext.util.clazz.scan.ClassScanUtil;

import java.util.*;

/*
    author: 江理网猿
    date: 2020/7/31 0031
*/
public class ClassScanKit {
    private final Set<String> includeJars = new HashSet<>();
    private Map<Class<?>, Set<Class<?>>> resultMap;
    private Thread scanThread;
    private boolean scanJar = true;

    public ClassScanKit() {}

    public ClassScanKit(boolean scanJar) {
        this.scanJar = scanJar;
    }

    public ClassScanKit scan(String packageName, List<Class<?>> scanClass) {
        // true: 扫描jar包
        scanThread = scanJar
                ? new Thread(() -> resultMap = ClassScanUtil.scanPackage(packageName, this::scanJar, scanClass))
                : new Thread(() -> resultMap = ClassScanUtil.scanPackage(packageName, scanClass));
        scanThread.start();
        return this;
    }

    public ClassScanKit scan(String packageName, Class<?>[] scanClass) {
        return this.scan(packageName, Arrays.asList(scanClass));
    }

    public Set<Class<?>> getResult(Class<?> clazz){
        if(scanThread.isAlive()){
            try {
                scanThread.join();
            } catch (InterruptedException ignored) {}
        }

        if(resultMap.containsKey(clazz)){
            return resultMap.get(clazz);
        }
        return Collections.emptySet();
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public boolean scanJar(String jarName){
        for (String name : includeJars) {
            if (jarName.endsWith(name)) {
                return true;
            }
        }
        return false;
    }

    public ClassScanKit addJars(String... jars) {
        return addJars(Arrays.asList(jars));
    }

    public ClassScanKit addJars(List<String> jars) {
        if (jars != null && !jars.isEmpty()) {
            jars.forEach((jarName) -> {
                includeJars.add(jarName.trim());
            });
        }
        return this;
    }

}
