package com.jfinal.ext.util.clazz.scan;

import com.jfinal.ext.util.Console;
import com.jfinal.ext.util.MyUtil;
import com.jfinal.ext.util.server.URLUtils;
import com.jfinal.kit.StrKit;
import com.jfinal.log.Log;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.*;
import java.util.function.Function;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * 该类来源于#hutool#
 *
 * 地址：http://git.oschina.net/loolly/hutool
 *
 * 类工具类
 * 1、扫描指定包下的所有类
 * 参考 http://www.oschina.net/code/snippet_234657_22722
 * @author seaside_hi, xiaoleilu
 *
 */
public final class ClassScanUtil {
    private static final Log log = Log.getLog(ClassScanUtil.class);

    /** Class文件扩展名 */
    private static final String CLASS_EXT = ".class";
    /** Jar文件扩展名 */
    private static final String JAR_FILE_EXT = ".jar";
    /** 在Jar中的路径jar的扩展名形式 */
    private static final String JAR_PATH_EXT = ".jar!";
    /** 当Path为文件形式时, path会加入一个表示文件的前缀 */
    private static final String PATH_FILE_PRE = "file:";

    private static final Function<String, Boolean> notScanJarFilter = (jarFileName)-> false;

    private ClassScanUtil() {
        // 静态类不可实例化
    }

    /**
     * 扫面包路径下满足class过滤器条件的所有class文件（支持中文目录）
     * 如果包路径为 com.abs + A.class 但是输入 abs会产生classNotFoundException</br>
     * 因为className 应该为 com.abs.A 现在却成为abs.A,此工具类对该异常进行忽略处理,有可能是一个不完善的地方，以后需要进行修改</br>
     *
     * @param packageName 包路径 com | com. | com.abs | com.abs.
     * @return 类集合
     */
    public static Set<Class<?>> scanPackage(String packageName, Function<String, Boolean> jarFilter, Class<?> clazz) {
        return scanPackage(packageName, jarFilter, new Class<?>[]{clazz}).get(clazz);
    }

    public static Set<Class<?>> scanPackage(String packageName, Class<?> clazz) {
        return scanPackage(packageName, notScanJarFilter, new Class<?>[]{clazz}).get(clazz);
    }

    public static Map<Class<?>, Set<Class<?>>> scanPackage(String packageName, Class<?>...classArray) {
        return scanPackage(packageName, notScanJarFilter, Arrays.asList(classArray));
    }

    public static Map<Class<?>, Set<Class<?>>> scanPackage(String packageName, Function<String, Boolean> jarFilter, Class<?>...classArray) {
        return scanPackage(packageName, jarFilter, Arrays.asList(classArray));
    }

    public static Map<Class<?>, Set<Class<?>>> scanPackage(String packageName, List<Class<?>> classList) {
        return scanPackage(packageName, notScanJarFilter, classList);
    }

    public static Map<Class<?>, Set<Class<?>>> scanPackage(String packageName, Function<String, Boolean> jarFilter, List<Class<?>> classList) {
        packageName = (null == packageName) ? "" : getWellFormedPackageName(packageName);

        final Map<Class<?>, Set<Class<?>>> classes = new HashMap<>(classList.size());
        for (Class<?> clazz : classList) {
            classes.put(clazz, new HashSet<>());
        }

        // 先扫描jar
        if(!jarFilter.equals(notScanJarFilter)){
            for (String jarName : getJavaClassPaths()) {
                if(jarName.endsWith(".jar") && jarFilter.apply(jarName)){
                    Console.info("[scan] jar: %s", jarName);
                    jarName = URLUtils.decoder(jarName);
                    fillClasses(jarName, new File(jarName), packageName, classes);
                }
            }
        }

        // 填充 classes, 对中文目录支持
        for (String classPath : getClassPaths(packageName)) {
            classPath = MyUtil.formatPath(URLUtils.decoder(classPath).substring(1));
            Console.info("[scan] path: %s", classPath);
            fillClasses(classPath, packageName, classes);
        }
        return classes;
    }

    // - - - - - - - -  - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    /**
     * 获得ClassPath
     * @param packageName 包名称
     * @return ClassPath路径字符串集合
     */
    public static Set<String> getClassPaths(String packageName){
        String packagePath = StrKit.isBlank(packageName) ? "" :
                packageName.replace(".", "/");
        Enumeration<URL> resources;
        try {
            resources = getClassLoader().getResources(packagePath);
        } catch (IOException e) {
            throw new RuntimeException(String.format("Loading classPath [%s] error!", packageName), e);
        }
        Set<String> paths = new HashSet<>();
        while(resources.hasMoreElements()) {
            paths.add(resources.nextElement().getPath());
        }
        return paths;
    }

    /**
     * @return 获得Java ClassPath路径，不包括 jre
     */
    public static String[] getJavaClassPaths() {
        return System.getProperty("java.class.path").split(System.getProperty("path.separator"));
    }

    /**
     * @return 当前线程的class loader
     */
    public static ClassLoader getContextClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    /**
     * 获得class loader
     * 若当前线程class loader不存在，取当前类的class loader
     * @return 类加载器
     */
    public static ClassLoader getClassLoader() {
        ClassLoader classLoader = getContextClassLoader();
        if(classLoader == null) {
            classLoader = ClassScanUtil.class.getClassLoader();
        }
        return classLoader;
    }



    //--------------------------------------------------------------------------------------------------- Private method start
    /**
     * 文件过滤器，过滤掉不需要的文件
     * 只保留Class文件、目录和Jar
     */
    private static final FileFilter fileFilter = pathname -> isClass(pathname.getName()) || pathname.isDirectory() || isJarFile(pathname);

    /**
     * 改变 com -> com. 避免在比较的时候把比如 completeTestSuite.class类扫描进去，如果没有"."</br>
     * 那class里面com开头的class类也会被扫描进去,其实名称后面或前面需要一个 ".",来添加包的特征
     *
     * @param packageName 原包名称
     * @return 格式化后的包名
     */
    private static String getWellFormedPackageName(String packageName) {
        return packageName.lastIndexOf('.') != packageName.length() - 1 ? packageName + '.' : packageName;
    }

    /**
     * 去掉指定前缀
     *
     * @param str 字符串
     * @param prefix 前缀
     * @return 切掉后的字符串，若前缀不是 preffix， 返回原字符串
     */
    private static String removePrefix(String str, String prefix) {
        if (str != null && str.startsWith(prefix)) {
            return str.substring(prefix.length());
        }
        return str;
    }

    /**
     * 填充满足条件的class 填充到 classes
     * 同时会判断给定的路径是否为Jar包内的路径，如果是，则扫描此Jar包
     *
     * @param path Class文件路径或者所在目录Jar包路径
     * @param packageName 需要扫面的包名
     * @param classes List 集合
     */
    private static void fillClasses(String path, String packageName, Map<Class<?>,Set<Class<?>>> classes) {
        //判定给定的路径是否为Jar
        int index = path.lastIndexOf(JAR_PATH_EXT);
        if(index != -1) {
            //Jar文件
            path = path.substring(0, index + JAR_FILE_EXT.length());	//截取jar路径

            path = removePrefix(path, PATH_FILE_PRE);	//去掉文件前缀

            processJarFile(new File(path), packageName, classes);
        }else {
            fillClasses(path, new File(path), packageName, classes);
        }
    }

    /**
     * 填充满足条件的class 填充到 classes
     *
     * @param classPath 类文件所在目录，当包名为空时使用此参数，用于截掉类名前面的文件路径
     * @param file Class文件或者所在目录Jar包文件
     * @param packageName 需要扫面的包名
     * @param classes List 集合
     */
    private static void fillClasses(String classPath, File file, String packageName, Map<Class<?>,Set<Class<?>>> classes) {
        if (file.isDirectory()) {
            processDirectory(classPath, file, packageName, classes);
        } else if (isClassFile(file)) {
            processClassFile(classPath, file, packageName, classes);
        } else if (isJarFile(file)) {
            processJarFile(file, packageName, classes);
        }
    }

    /**
     * 处理如果为目录的情况,需要递归调用 fillClasses方法
     *
     * @param directory 目录
     * @param packageName 包名
     * @param classes 类集合
     */
    private static void processDirectory(String classPath, File directory, String packageName, Map<Class<?>,Set<Class<?>>> classes) {
        for (File file : Objects.requireNonNull(directory.listFiles(fileFilter))) {
            fillClasses(classPath, file, packageName, classes);
        }
    }

    /**
     * 处理为class文件的情况,填充满足条件的class 到 classes
     *
     * @param classPath 类文件所在目录，当包名为空时使用此参数，用于截掉类名前面的文件路径
     * @param file class文件
     * @param packageName 包名
     * @param classes 类集合
     */
    private static void processClassFile(String classPath, File file, String packageName, Map<Class<?>,Set<Class<?>>> classes) {
        if(!classPath.endsWith(File.separator)) {
            classPath += File.separator;
        }
        String path = file.getAbsolutePath();
        if(StrKit.isBlank(packageName)) {
            path = removePrefix(path, classPath);
        }
        final String filePathWithDot = path.replace(File.separator, ".");

        int subIndex;
        if ((subIndex = filePathWithDot.indexOf(packageName)) != -1) {
            final int endIndex = filePathWithDot.lastIndexOf(CLASS_EXT);

            final String className = filePathWithDot.substring(subIndex, endIndex);
            fillClass(className, packageName, classes);
        }
    }

    /**
     * 处理为jar文件的情况，填充满足条件的class 到 classes
     *
     * @param file jar文件
     * @param packageName 包名
     * @param classes 类集合
     */
    private static void processJarFile(File file, String packageName, Map<Class<?>,Set<Class<?>>> classes) {
        try {
            for (JarEntry entry : Collections.list(new JarFile(file).entries())) {
                if (isClass(entry.getName())) {
                    final String className = entry.getName().replace("/", ".").replace(CLASS_EXT, "");
                    fillClass(className, packageName, classes);
                }
            }
        } catch (Throwable ex) {
//            log.error(ex.getMessage(), ex);
        }
    }

    /**
     * 填充class 到 classes
     *
     * @param className 类名
     * @param packageName 包名
     * @param classes 类集合
     */
    private static void fillClass(String className, String packageName, Map<Class<?>,Set<Class<?>>> classes) {
        if (className.startsWith(packageName)) {
            try {

                final Class<?> clazz = Class.forName(className, false, getClassLoader());
                for (Class<?> tempClazz : classes.keySet()){
                    // tempClazz是clazz的父类或接口
                    if(tempClazz.isAssignableFrom(clazz) && !tempClazz.equals(clazz)){
                        classes.get(tempClazz).add(clazz);
                    }

                    // tempClazz是注解且clazz类前加了此注解
                    if(tempClazz.isAnnotation() && clazz.isAnnotationPresent((Class<? extends Annotation>) tempClazz)){
                        classes.get(tempClazz).add(clazz);
                    }
                }
            } catch (Throwable ex) {
//                ex.printStackTrace();
//                log.error("Load class %s error!", className);
            }
        }
    }

    /**
     * @param file 文件
     * @return 是否为类文件
     */
    private static boolean isClassFile(File file) {
        return isClass(file.getName());
    }

    /**
     * @param fileName 文件名
     * @return 是否为类文件
     */
    private static boolean isClass(String fileName) {
        return fileName.endsWith(CLASS_EXT);
    }

    /**
     * @param file 文件
     * @return 是否为Jar文件
     */
    private static boolean isJarFile(File file) {
        return file.getName().endsWith(JAR_FILE_EXT);
    }
    //--------------------------------------------------------------------------------------------------- Private method end

    /**
     * 确定class是否可以被加载
     * @param className 类名称
     * @param classLoader 类加载器
     * @return 是否可以被加载
     */
    public static boolean isPresent(String className, ClassLoader classLoader) {
        try {
            Class.forName(className, true, classLoader);
            return true;
        }
        catch (Throwable ex) {
            // Class or one of its dependencies is not present...
            return false;
        }
    }
}