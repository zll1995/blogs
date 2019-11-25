package com.jk.role.service;

import com.jk.role.model.Role;

import java.util.List;

/**
 * @ClassName RoleService
 * @Description: TODO
 * @Author zjh
 * @Date 2019/11/20 15:41
 * @Version V1.0
 **/
public interface RoleService {

    List<Role> queryRoleList();

    void addRole(Role role);

    void delRole(Integer id);

    Role queryRoleById(Integer id);

}
