package com.oillab.common.role;/*
package com.oillab.common.role;

import com.common.base.model.generate.TmPermission;
import com.common.base.model.generate.TmRole;
import com.common.base.model.generate.TmService;


import java.util.List;

*/
/*
    author: Timor
    date: 2019/12/13 0013
*//*

public class RoleService {
    private static final TmRole role = new TmRole();
    private static final TmPermission permission = new TmPermission();
    private static final TmService webService = new TmService();

    */
/**
     * 获取用户拥有的权限
     * @param userId 用户id
     * @return list<String : role>
     *//*

    public List<TmRole> getRoleForUser(String userId){
        String sql = "SELECT * FROM tm_role WHERE id=(SELECT roleId FROM tm_user_role WHERE userId=?)";
        return role.find(sql, userId);
    }

    public List<TmRole> getAllRole(){
        List<TmRole> allRole = role.findAll();
//        System.out.println("[getAllRole] AllRole: " + allRole);
        return allRole;
    }
    public List<TmService> getAllService(){
        List<TmService> allService = webService.findAll();
//        System.out.println("[getAllService] AllWebService: " + allService);
        return allService;
    }

    public List<TmPermission> getPermissionByRole(Object roleId){
        String sql = "SELECT * from tm_permission where id in "
                +"(SELECT permissionId FROM tm_role_permission where  roleId=?)";
        return permission.find(sql, roleId);
    }

    public TmPermission getPermissionByService(String serviceUrl){
        String sql = "SELECT * from tm_permission where serviceId = "
                +"(SELECT id FROM tm_service where url=?) Limit 1";
        return permission.findFirst(sql, serviceUrl);
    }
}
*/
