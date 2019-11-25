package com.jk.user.mapper;

import com.jk.role.model.Role;
import com.jk.user.model.AdminUser;
import com.jk.user.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName UserMapper
 * @Description: TODO
 * @Author zjh
 * @Date 2019/11/18 20:27
 * @Version V1.0
 **/
public interface UserMapper {
    List<User> queryUserList();

    List<AdminUser> queryAdminUser();

    AdminUser queryAdminUserById(Integer id);

    void updAdminUser(AdminUser adminUser);

    void deleteUserByIds(@Param("ids") String ids);

    void deleteUserRoleByIds(@Param("ids")String ids);

    Integer queryUserOfRole(Integer id);

    void addUserRole(@Param("id")String ids, @Param("roleId")Integer roleId);

    AdminUser queryUserByUsername(@Param("username")String username);

    void updPwd(@Param("id")Integer id, @Param("pwd")String pwd);
}
