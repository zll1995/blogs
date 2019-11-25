package com.jk.role.service;

import com.jk.role.mapper.RoleMapper;
import com.jk.role.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName RoleServiceImpl
 * @Description: TODO
 * @Author zjh
 * @Date 2019/11/20 15:41
 * @Version V1.0
 **/
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> queryRoleList() {
        return roleMapper.queryRoleList();
    }

    @Override
    public void addRole(Role role) {
        if(role.getRid()==null) {
            roleMapper.addRole(role);
        }else {
            roleMapper.updRole(role);
        }
    }

    @Override
    public void delRole(Integer id) {
        roleMapper.delRole(id);
    }

    @Override
    public Role queryRoleById(Integer id) {
        return roleMapper.queryRoleById(id);
    }
}
