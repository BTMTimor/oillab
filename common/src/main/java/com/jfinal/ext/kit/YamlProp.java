package com.jfinal.ext.kit;

import com.jfinal.core.Const;
import com.jfinal.kit.Prop;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

/*
    author: 江理网猿
    date: 2020/7/31 0031
*/
public class YamlProp extends Prop {

    public YamlProp(String yamlFile) {
        this(yamlFile, Const.DEFAULT_ENCODING);
    }

    public YamlProp(String fileName, String encoding){
        InputStream inputStream = getClassLoader().getResourceAsStream(fileName);
        if (null == inputStream) {
            throw new IllegalArgumentException("Properties file not found in classpath: " + fileName);
        }
        initYaml(inputStream, encoding);
    }

    public YamlProp(File file) {
        this(file, Const.DEFAULT_ENCODING);
    }

    public YamlProp(File file, String encoding) {
        try {
            if(!(file.exists() && file.canRead()))
                throw new IllegalArgumentException("Properties file not found in classpath: " + file.getName());

            initYaml(new FileInputStream(file), encoding);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void initYaml(InputStream in, String encoding){
        LinkedHashMap map;
        Properties properties = new Properties();
        try {
            Yaml yaml = new Yaml();
//            map = yaml.loadAs(in, LinkedHashMap.class);
            assert null != in;
            assert null != encoding;

            map = yaml.loadAs(new InputStreamReader(in, encoding), LinkedHashMap.class);
            if(null != map) setProperties(properties, map,"");}
        catch (Exception e) {
            e.printStackTrace();
        }
        this.properties = properties;
    }

    private static void setProperties(Properties properties, Map map, String prefix) {
        for (Object key :map.keySet()){
            if(key == null) continue;

            Object value = map.get(key);
            if(value instanceof Map){
                setProperties(properties, (Map) value,prefix + key.toString()+".");
            }else {
                if(value == null) continue;
                //System.out.println(prefix+key.toString()+"="+value.toString());
                properties.setProperty(prefix + key.toString(), value.toString());
            }
        }
    }


    private ClassLoader getClassLoader() {
        ClassLoader ret = Thread.currentThread().getContextClassLoader();
        return ret != null ? ret : getClass().getClassLoader();
    }
}