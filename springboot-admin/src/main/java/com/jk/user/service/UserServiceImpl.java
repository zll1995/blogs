package com.jk.user.service;

import com.jk.role.model.Role;
import com.jk.user.mapper.UserMapper;
import com.jk.user.model.AdminUser;
import com.jk.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName UserServiceImpl
 * @Description: TODO
 * @Author zjh
 * @Date 2019/11/18 20:27
 * @Version V1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryUserList() {
        return userMapper.queryUserList();
    }

    @Override
    public List<AdminUser> queryAdminUser() {
        return userMapper.queryAdminUser();
    }

    @Override
    public AdminUser queryAdminUserById(Integer id) {
        return userMapper.queryAdminUserById(id);
    }

    @Override
    public void updAdminUser(AdminUser adminUser) {
        userMapper.updAdminUser(adminUser);
    }

    @Override
    public void deleteUserByIds(String ids) {
        userMapper.deleteUserRoleByIds(ids);
        userMapper.deleteUserByIds(ids);
    }

    @Override
    public Integer queryUserOfRole(Integer id) {
        return userMapper.queryUserOfRole(id);
    }

    @Override
    public void updUserRole(String ids, Integer roleId) {
        userMapper.deleteUserRoleByIds(ids);
        userMapper.addUserRole(ids,roleId);
    }

    @Override
    public AdminUser queryUserByUsername(String username) {
        return userMapper.queryUserByUsername(username);
    }

    @Override
    public void updPwd(Integer id, String pwd) {
        userMapper.updPwd(id,pwd);
    }


}
