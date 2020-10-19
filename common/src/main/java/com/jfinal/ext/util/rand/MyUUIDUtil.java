package com.jfinal.ext.util.rand;

import com.jfinal.kit.StrKit;

import java.util.*;

/*
    author: Timor
    date: 2019/11/18 0018
*/
public class MyUUIDUtil {
    public static String getUUID(){
        String uuid = UUID.randomUUID().toString().toUpperCase();
        // return uuid.replaceAll("-", "");
        StringBuilder sb = new StringBuilder(uuid);
        sb.deleteCharAt(23).deleteCharAt(18);
        sb.deleteCharAt(13).deleteCharAt(8);
        return sb.toString();
    }

    public static String[] getUUIDArray(int num) {
        String[] uuid = new String[num];
        if (num >= 1) {
            for (int i = 0; i < num; i++) {
                uuid[i] = getUUID();
            }
        }
        return uuid;
    }

    public static List<String> getUUIDList(int num) {
        return Arrays.asList(getUUIDArray(num));
        /*
        List<String> uuid = new ArrayList<>(num);
        if (num >= 1) {
            for (int i = 0; i < num; i++) {
                uuid.add(getUUID());
            }
        }
        return uuid;*/
    }
}
