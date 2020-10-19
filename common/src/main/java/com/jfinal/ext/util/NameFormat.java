package com.jfinal.ext.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    author: 江理网猿
    date: 2020/7/28 0028
*/
public class NameFormat {
    private static final Pattern linePattern = Pattern.compile("_(\\w)");
    // 驼峰命名法(CamelCase)

    public static String toClassName(String str) {
        return toCamelCase2(str, true);
    }

    public static String toRoute(String str) {
        return str.toLowerCase().replace("_", "/");
    }

    public static String toPackage(String str) {
        return str.toLowerCase().replace("_", ".");
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    // 转换为驼峰格式
    public static String toCamelCase2(String str) {
        return toCamelCase2(str, false);
    }

    // 转换为驼峰格式
    public static String toCamelCase2(String str, boolean upFirstChar) {
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);

        // 是否将首字母大写
        if(upFirstChar) {
            sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        }
        return sb.toString();
    }

    // 下划线命名法(UnderScoreCase)
    public static String toUnderScoreCase(String string){
        return toUnderScoreCase(string, true);
    }


    // 下划线命名法(UnderScoreCase)
    public static String toUnderScoreCase(String string, boolean toUpperCase){
        if(toUpperCase){
            return string.replaceAll("[A-Z]", "_$0").toUpperCase();
        }
        return string.replaceAll("[A-Z]", "_$0").toLowerCase();
    }
}
