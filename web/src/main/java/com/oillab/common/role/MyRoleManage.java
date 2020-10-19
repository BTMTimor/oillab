package com.oillab.common.role;/*
package com.oillab.common.role;

import com.common.base.model.generate.TmPermission;
import com.common.base.model.generate.TmRole;
import com.common.base.model.generate.TmService;

import java.util.*;

*/
/*
    author: Timor
    date: 2019/12/13 0013
*//*

public class MyRoleManage {
    // <role : permissionSet>，可以不用校验permissionSet为null的情况
    private static final Map<String, HashSet<String>> rolePermission =  new HashMap<>();
    private static final Map<String, String> servicePermission =  new HashMap<>();
    private static final Map<String, HashSet<String>> userRole =  new HashMap<>();
    private final RoleService roleService =  new RoleService();
    private static volatile MyRoleManage me;

    private MyRoleManage() {
        // 获取所有数据：角色==》权限，即：role：permission
        List<TmRole> allRole = roleService.getAllRole();
        for (TmRole role : allRole) {
            List<TmPermission> permissionList = roleService.getPermissionByRole(role.getId());
            HashSet<String> permissionSet = new HashSet<>();
            for (TmPermission permission: permissionList) {
                permissionSet.add(permission.getName());
            }
            rolePermission.put(role.getName(), permissionSet);
        }

        // 获取所有数据：url==》权限，即：webService：permission
        List<TmService> allService = roleService.getAllService();
        for (TmService service : allService) {
            TmPermission permission = roleService.getPermissionByService(service.getUrl());
            if(null == permission.getName() || null == service.getUrl()){
                System.out.print(permission.getName() + " : ");
                System.out.println(service.getUrl());
            }
            servicePermission.put(service.getUrl(), permission.getName());
        }

    }

    public static MyRoleManage me(){
        if(null == me){
            synchronized (MyRoleManage.class){
                if(null == me){
                    me = new MyRoleManage();
                }
            }
        }
        return me;
    }
    */
/**
     * 获取用户拥有的权限
     * @param userId 用户id
     * @return list\<role>
     *//*

    public HashSet<String> getRoleForUser(String userId){
        if(null == userId) {
            return new HashSet<>();
        }
        HashSet<String> roles = userRole.get(userId);
        if (roles.isEmpty()){
            return new HashSet<>();
        }
        List<TmRole> roleForUser = roleService.getRoleForUser(userId);
        if(!roleForUser.isEmpty()){
            for(TmRole role : roleForUser){
                roles.add(role.getName());
            }
        }
        userRole.put(userId, roles);
        return new HashSet<>(roles);
    }

    public HashSet<String> getPermissionForRole(String role){
        HashSet<String> permissionSet = rolePermission.get(role);
        if(null == permissionSet){
            return new HashSet<>();
        }
        return new HashSet<>(permissionSet);
    }

    public String getPermissionForUrl(String url){
        return servicePermission.get(url);
    }

    public HashSet<String> getPermissionForUser(String userId){
        HashSet<String> permissionSet = new HashSet<>();
        List<TmRole> roleForUser = roleService.getRoleForUser(userId);
//        System.out.println("[getPermissionForUser] " + roleForUser);
        if(!roleForUser.isEmpty()){
            for (TmRole role:roleForUser) {
                permissionSet.addAll(this.getPermissionForRole(role.getName()));
            }
            return new HashSet<>(permissionSet);
        }
        return permissionSet;
    }

    public boolean hasRole(String userId, String role){
        return getRoleForUser(userId).contains(role);
    }
    public boolean hasAnyRole(String userId, String...role){
        HashSet<String> userRoleSet = getRoleForUser(userId);
        for(String roleName : role){
            if(userRoleSet.contains(roleName)){
                return true;
            }
        }
        return false;
    }
    public boolean hasAllRole(String userId, String...role){
        HashSet<String> userRoleSet = getRoleForUser(userId);
        return userRoleSet.containsAll(Arrays.asList(role));
    }


    public boolean hasPermission(String role, String permission){
        HashSet<String> permissionSet = rolePermission.get(role);
        return permissionSet.contains(permission);
    }

    public boolean hasAnyPermission(String role, String...permission){
        HashSet<String> permissionSet = rolePermission.get(role);
        if(!permissionSet.isEmpty()){
            for (String p: permission) {
                if(permissionSet.contains(p)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasAllPermission(String role, String...permission){
        HashSet<String> permissionSet = rolePermission.get(role);
        if(!permissionSet.isEmpty()){
            for (String p: permission) {
                if(!permissionSet.contains(p)){
                    return false;
                }
            }
        }
        return false;
    }

}
*/
