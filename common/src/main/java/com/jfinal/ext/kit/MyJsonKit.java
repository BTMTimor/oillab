package com.jfinal.ext.kit;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Array;

/*
    author: 江理网猿
    date: 2020/8/30 0030
*/
public class MyJsonKit {

    public static boolean isArrayOrJSON(Object object){
        return JSONObject.class == object.getClass()
                || Array.class == object.getClass();
    }

    // merge target to source
    public static void mergeJSON(JSONObject source, JSONObject target){
        for (String key : target.keySet()) {
            if (source.containsKey(key) && isArrayOrJSON(source.get(key))) {
                mergeJSON(source.getJSONObject(key), target.getJSONObject(key));
            }else {
                source.put(key, target.get(key));
            }
        }
    }
}
