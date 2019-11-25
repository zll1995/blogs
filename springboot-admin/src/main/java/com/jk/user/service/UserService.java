package com.jk.user.service;

import com.jk.role.model.Role;
import com.jk.user.model.AdminUser;
import com.jk.user.model.User;

import java.util.List;
import java.util.Map;

/**
 * @ClassName UserService
 * @Description: TODO
 * @Author zjh
 * @Date 2019/11/18 20:26
 * @Version V1.0
 **/
public interface UserService {
    List<User> queryUserList();

    List<AdminUser> queryAdminUser();

    AdminUser queryAdminUserById(Integer id);

    void updAdminUser(AdminUser adminUser);

    void deleteUserByIds(String ids);

    Integer queryUserOfRole(Integer id);

    void updUserRole(String ids, Integer roleId);

    AdminUser queryUserByUsername(String username);

    void updPwd(Integer id, String pwd);
}
