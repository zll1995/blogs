package com.jk.role.mapper;

import com.jk.role.model.Role;

import java.util.List;

/**
 * @ClassName RoleMapper
 * @Description: TODO
 * @Author zjh
 * @Date 2019/11/20 15:41
 * @Version V1.0
 **/
public interface RoleMapper {

    List<Role> queryRoleList();

    void addRole(Role role);

    void delRole(Integer id);

    Role queryRoleById(Integer id);

    void updRole(Role role);

}
