package com.jfinal.ext.annotation.service;

import com.jfinal.kit.Kv;
import com.jfinal.plugin.activerecord.Record;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/*
    author: Timor
    date: 2020/2/23 0023
*/
public class AnnotationService {
    private final HashSet<String> set;
    private final NameFormatter format;

    public AnnotationService() {
        // 这四个方法是annotation默认有的，要排除在外。
        this.set = new HashSet<String>(Arrays.asList("equals", "toString", "hashCode", "annotationType"));
        this.format = new DefaultNameFormatter();
    }

    public AnnotationService(NameFormatter format) {
        // 这四个方法是annotation默认有的，要排除在外。
        this.set = new HashSet<>(Arrays.asList("equals", "toString", "hashCode", "annotationType"));
        this.format = format;
    }

    public Map<String, Object> getAnnotationToMap(Annotation annotation) {
        HashMap<String, Object> map = new HashMap<>();
        Method[] methods = annotation.getClass().getDeclaredMethods();
        for (Method med : methods) {
            if(!set.contains(med.getName())){
                String name = med.getName();
                try {
                    Object value = med.invoke(annotation);
                    map.put(name, value);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return map;
    }


    public Kv getAnnotationToKv(Annotation annotation) {
        return new Kv().set(getAnnotationToMap(annotation));
    }

    public Kv getAnnotationToKv(AnnotatedElement annotatedElement,
               Class<? extends Annotation> annotationClazz){
        Annotation annotation = annotatedElement.getAnnotation(annotationClazz);
        if(null != annotation){
            return this.getAnnotationToKv(annotation);
        }
        return new Kv();
    }




    public Record getAnnotationToRecord(Annotation annotation) {
        Record record = new Record();
        Map<String, Object> map = this.getAnnotationToMap(annotation);
        for (String key : map.keySet()) {
            record.set(key, map.get(key));
        }
        return record;
    }

    public Record getAnnotationToRecord(AnnotatedElement annotatedElement,
                Class<? extends Annotation> annotationClazz) {
        Record record;
        Annotation annotation = annotatedElement.getAnnotation(annotationClazz);
        if(null != annotation){
            record = this.getAnnotationToRecord(annotation);
        }else{
            record = new Record();
        }
        return record;
    }

    public List<Record> getToRecord(Class<?> clazz, Class<? extends Annotation> annotationClazz){
        return null;
    }
}
