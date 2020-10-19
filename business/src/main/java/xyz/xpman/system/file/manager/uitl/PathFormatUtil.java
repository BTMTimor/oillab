package xyz.xpman.system.file.manager.uitl;


import com.jfinal.ext.util.rand.MyUUIDUtil;
import com.jfinal.ext.util.rand.RandomStrUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    author: 江理网猿
    date: 2020/10/10 0010
*/
public class PathFormatUtil {
    public static final String PATTERN_STRING = "\\{([^\\}]+)\\}";
    private static final String TIME = "time";
    private static final String FULL_YEAR = "yyyy";
    private static final String YEAR = "yy";
    private static final String MONTH = "MM";
    private static final String DAY = "dd";
    private static final String HOUR = "HH";
    private static final String MINUTE = "mm";
    private static final String SECOND = "ss";
    private static final String TIME_MILL = "SS";
    private static final String NANO_TIME = "NANO_TIME";

    private static final String UPLOADER_ID = "uploader";

    private static final String NEXT_SEQ = "NEXT_SEQ";

    private static final String UUID = "UUID";
    private static final String RAND = "RAND";// default: rand_num
    private static final String RANDOM_NUM = "RANDOM_NUM";
    private static final String RANDOM_CHAR = "RANDOM_CHAR";
    private static final String RANDOM_MIX = "RANDOM_MIX";

    private static final Map<String, Supplier<String>> formatPattern = new HashMap<String, Supplier<String>>(){{
        final String[] patternFlag =
                {FULL_YEAR, YEAR, MONTH, DAY, HOUR, MINUTE, SECOND, TIME_MILL};
        for (String flag : patternFlag) {
            put(flag, ()-> (new SimpleDateFormat(flag)).format(getCurrentDate()));
        }

        put(UPLOADER_ID, PathFormatUtil::getUploaderId);

        put(UUID, MyUUIDUtil::getUUID);
        put(NANO_TIME, ()-> String.valueOf(System.nanoTime()));
        put(TIME, ()-> String.valueOf(System.currentTimeMillis()));
    }};

    private static final Map<String, Function<Integer, String>> formatFunc = new HashMap<String, Function<Integer, String>>(){{
        put(RAND, RandomStrUtils::randomNumeric);
        put(RANDOM_NUM, RandomStrUtils::randomNumeric);
        put(RANDOM_MIX, RandomStrUtils::randomAlphanumeric);
        put(RANDOM_CHAR, RandomStrUtils::randomAlphabetic);
    }};

    private static final ThreadLocal<Object> uploaderId = new ThreadLocal<>();
    private static final ThreadLocal<Date> dateThreadLocal = new ThreadLocal<>();

    public static Date getCurrentDate(){
        Date date = dateThreadLocal.get();
        if(null == date){
            dateThreadLocal.set(date = new Date());
        }
        return date;
    }

    public static String getUploaderId(){
        return String.valueOf(uploaderId.get());
    }

    public static void setUploaderId(Object id){
        uploaderId.set(id);
    }


    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -


    public static String parse(String input) {
        Pattern pattern = Pattern.compile(PATTERN_STRING, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        StringBuffer sb = new StringBuffer();

        while(matcher.find()) {
            matcher.appendReplacement(sb, format(matcher.group(1)));
        }

        matcher.appendTail(sb);
        dateThreadLocal.remove();
        return sb.toString();
    }

    public static String parse(String input, String filename) {
        Pattern pattern = Pattern.compile(PATTERN_STRING, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(input);
        String matchStr;
        StringBuffer sb = new StringBuffer();

        while(matcher.find()) {
            matchStr = matcher.group(1);
            if (matchStr.contains("fileName")) {
                filename = filename.replace("$", "\\$")
                        .replaceAll("[\\/:*?\"<>|]", "");
                matcher.appendReplacement(sb, filename);
            } else {
                matcher.appendReplacement(sb, format(matchStr));
            }
        }

        dateThreadLocal.remove();
        matcher.appendTail(sb);
        return sb.toString();
    }

    private static String format(String pattern) {
        if(formatPattern.containsKey(pattern)){
            return formatPattern.get(pattern).get();
        }

        String[] split = pattern.split(":");
        String temp = split[0].trim();
        if(formatFunc.containsKey(temp)){
            return formatFunc.get(temp)
                    .apply(Integer.parseInt(split[1].trim()));
        }
        return pattern;
    }

}
