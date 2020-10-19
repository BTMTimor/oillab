package com.jfinal.ext.util.server;

import com.jfinal.kit.StrKit;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * URL相关工具类
 * @title URLUtils.java
 * @company 北京思维夫网络科技有限公司
 * @url http://www.meitimao.com
 * @author 卢春梦
 * @version 1.0
 * @created 2015年7月15日上午11:01:32
 */
public class URLUtils {
    private final static String CHARSET = "UTF-8";

    /**
     * URL编码
     */
    public static String encoder(String url) {
        try {
            return URLEncoder.encode(url, CHARSET);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * URL解码
     */
    public static String decoder(String url) {
        try {
            return URLDecoder.decode(url, CHARSET);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 构建post paras
     */
    public static String buildParas(Map<String, String> paras) {
        if (paras == null || paras.isEmpty()) {
            return null;
        }

        StringBuilder sb = new StringBuilder("");
        boolean isFirst = true;

        for (Entry<String, String> entry : paras.entrySet()) {
            if (isFirst) {
                isFirst = false;
            } else {
                sb.append("&");
            }

            String key = entry.getKey();
            String value = entry.getValue();
            if (StrKit.notBlank(value)) {
                try {value = URLEncoder.encode(value, CHARSET);} catch (UnsupportedEncodingException e) {throw new RuntimeException(e);}
            }
            sb.append(key).append("=").append(value);
        }
        return sb.toString();
    }

    /**
     * 将queryString 转换成map格式，方便获取参数
     */
    public static Map<String, String> queryStringToMap(String queryString) {
        Map<String, String> map = new HashMap<String, String>();
        if (StrKit.isBlank(queryString)) {
            return map;
        }
        // 兼容只有=和&、=的情况
        if (queryString.indexOf('&') != -1) {
            String[] params = queryString.split("&");
            for (String param : params) {
                String[] data = param.split("=");
                String value = data.length > 1 ? data[1] : "";
                map.put(data[0], value);
            }
        } else {
            String[] data = queryString.split("=");
            String value = data.length > 1 ? data[1] : "";
            map.put(data[0], value);
        }
        return map;
    }

}
