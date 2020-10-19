package com.jfinal.ext.kit;

import com.jfinal.core.Const;
import com.jfinal.ext.util.resources.ResourcesUtil;
import com.jfinal.kit.StrKit;

import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

/*
    author: 江理网猿
    date: 2020/7/31 0031
*/
public class YamlPropKit {
    private static YamlProp prop = null;
    private static final ConcurrentHashMap<String, YamlProp> map = new ConcurrentHashMap<>();

    private YamlPropKit() {}

    /**
     * Use the first found properties file
     */
    public static YamlProp useFirstFound(String... fileNames) {
        String fileName = ResourcesUtil.getFirstUsed(fileNames);
        if(StrKit.notBlank(fileName)){
            try {
                return use(fileName, Const.DEFAULT_ENCODING);
            } catch (Exception ignored) {}
        }

        throw new IllegalArgumentException("没有配置文件可被使用");
    }

    /**
     * Use the properties file. It will loading the properties file if not loading.
     * @see #use(String, String)
     */
    public static YamlProp use(String fileName) {
        return use(fileName, Const.DEFAULT_ENCODING);
    }

    /**
     * Use the properties file. It will loading the properties file if not loading.
     * <p>
     * Example:<br>
     * YamlPropKit.use("config.txt", "UTF-8");<br>
     * YamlPropKit.use("other_config.txt", "UTF-8");<br><br>
     * String userName = YamlPropKit.get("userName");<br>
     * String password = YamlPropKit.get("password");<br><br>
     *
     * userName = YamlPropKit.use("other_config.txt").get("userName");<br>
     * password = YamlPropKit.use("other_config.txt").get("password");<br><br>
     *
     * YamlPropKit.use("com/jfinal/config_in_sub_directory_of_classpath.txt");
     *
     * @param fileName the properties file's name in classpath or the sub directory of classpath
     * @param encoding the encoding
     */
    public static YamlProp use(String fileName, String encoding) {
        YamlProp result = map.get(fileName);
        if (result == null) {
            synchronized (YamlPropKit.class) {
                result = map.get(fileName);
                if (result == null) {
                    result = new YamlProp(fileName, encoding);
                    map.put(fileName, result);
                    if (YamlPropKit.prop == null) {
                        YamlPropKit.prop = result;
                    }
                    System.out.println("[info] use config: " + fileName);
                }
            }
        }
        return result;
    }

    /**
     * Use the properties file bye File object. It will loading the properties file if not loading.
     * @see #use(File, String)
     */
    public static YamlProp use(File file) {
        return use(file, Const.DEFAULT_ENCODING);
    }

    /**
     * Use the properties file bye File object. It will loading the properties file if not loading.
     * <p>
     * Example:<br>
     * YamlPropKit.use(new File("/var/config/my_config.txt"), "UTF-8");<br>
     * Strig userName = YamlPropKit.use("my_config.txt").get("userName");
     *
     * @param file the properties File object
     * @param encoding the encoding
     */
    public static YamlProp use(File file, String encoding) {
        YamlProp result = map.get(file.getName());
        if (result == null) {
            synchronized (YamlPropKit.class) {
                result = map.get(file.getName());
                if (result == null) {
                    result = new YamlProp(file, encoding);
                    map.put(file.getName(), result);
                    if (YamlPropKit.prop == null) {
                        YamlPropKit.prop = result;
                    }
                }
            }
        }
        return result;
    }

    public static YamlProp useless(String fileName) {
        YamlProp previous = map.remove(fileName);
        if (YamlPropKit.prop == previous) {
            YamlPropKit.prop = null;
        }
        return previous;
    }

    public static void clear() {
        prop = null;
        map.clear();
    }

    public static YamlProp append(YamlProp prop) {
        synchronized (YamlPropKit.class) {
            if (YamlPropKit.prop != null) {
                YamlPropKit.prop.append(prop);
            } else {
                YamlPropKit.prop = prop;
            }
            return YamlPropKit.prop;
        }
    }

    public static YamlProp append(String fileName, String encoding) {
        return append(new YamlProp(fileName, encoding));
    }

    public static YamlProp append(String fileName) {
        return append(fileName, Const.DEFAULT_ENCODING);
    }

    public static YamlProp appendIfExists(String fileName, String encoding) {
        try {
            return append(new YamlProp(fileName, encoding));
        } catch (Exception e) {
            return YamlPropKit.prop;
        }
    }

    public static YamlProp appendIfExists(String fileName) {
        return appendIfExists(fileName, Const.DEFAULT_ENCODING);
    }

    public static YamlProp append(File file, String encoding) {
        return append(new YamlProp(file, encoding));
    }

    public static YamlProp append(File file) {
        return append(file, Const.DEFAULT_ENCODING);
    }

    public static YamlProp appendIfExists(File file, String encoding) {
        if (file.exists()) {
            append(new YamlProp(file, encoding));
        }
        return YamlPropKit.prop;
    }

    public static YamlProp appendIfExists(File file) {
        return appendIfExists(file, Const.DEFAULT_ENCODING);
    }

    public static YamlProp getProp() {
        if (prop == null) {
            throw new IllegalStateException("Load propties file by invoking YamlPropKit.use(String fileName) method first.");
        }
        return prop;
    }

    public static YamlProp getProp(String fileName) {
        return map.get(fileName);
    }

    public static String get(String key) {
        return getProp().get(key);
    }

    public static String get(String key, String defaultValue) {
        return getProp().get(key, defaultValue);
    }

    public static Integer getInt(String key) {
        return getProp().getInt(key);
    }

    public static Integer getInt(String key, Integer defaultValue) {
        return getProp().getInt(key, defaultValue);
    }

    public static Long getLong(String key) {
        return getProp().getLong(key);
    }

    public static Long getLong(String key, Long defaultValue) {
        return getProp().getLong(key, defaultValue);
    }

    public static Boolean getBoolean(String key) {
        return getProp().getBoolean(key);
    }

    public static Boolean getBoolean(String key, Boolean defaultValue) {
        return getProp().getBoolean(key, defaultValue);
    }

    public static boolean containsKey(String key) {
        return getProp().containsKey(key);
    }
}