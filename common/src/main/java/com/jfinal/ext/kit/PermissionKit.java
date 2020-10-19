package com.jfinal.ext.kit;

import com.jfinal.kit.StrKit;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import java.util.*;

/*
    author: 江理网猿
    date: 2020/9/26 0026
*/
public class PermissionKit {
    private static PermissionKit me = null;
    private static final Set<String> permissions = new HashSet<>();
    // 若为伪静态，请使用 @Clear(xxx.class)
    /*private static final Set<String> forbidden = new HashSet<String>(){{
        add("/add");add("/update");add("/delete");add("/fakeDelete");
        add("/batch/?");add("/update");add("/delete");add("/fakeDelete");
    }};*/
    private static final List<String> permissionRule = new ArrayList<>();
    private static final String URL = "url";
    private static final String URI_MATCHER = "[A-Za-z0-9/]+";
    private static final String PARA_MATCHER = "[A-Za-z0-9]+";
    private static final String PARA_HOLDER = "?";

    private PermissionKit(){
        System.out.print("init permission kit....");
        init();
        System.out.println("complete!");
    }

    public static PermissionKit me() {
        if(null == me) { me = new PermissionKit(); }
        return me;
    }

    // 若为伪静态，请使用 @Clear(xxx.class)
    private static void init(){
        String sql = "SELECT url FROM `sys_permission` where status = 1 order by url";
        List<Record> records = Db.find(sql);
        if(records.isEmpty()) { return; }

        for (Record record : records) {
            String url = record.getStr(URL);
            if(StrKit.isBlank(url)) {continue;}

            if (url.matches(URI_MATCHER)){
                permissions.add(url);
                System.out.println("[permission]  equals: " + url);
            }else{
                permissionRule.add(url.replace(PARA_HOLDER, PARA_MATCHER));
                System.out.println("[permission] matcher: " + url);
            }
        }
        Collections.sort(permissionRule);
    }

    public boolean hasPermissions(String uri){
        if (permissions.contains(uri)){ return true;}

        for (String temp : permissionRule) {
            if(uri.matches(temp)){
                return true;
            }
        }
        return false;
    }

}
