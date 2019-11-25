package com.jk.user.mapper;

import com.jk.user.model.User;

/*
 * 登录根据用户名查看用户是否存在
 * */

public interface UserMapper {
    User queryUserByName(String username);

    User queryUserById(Integer userId);

    void saveUser(User user);

    User queryPhone(String phone);

    void saveIntegral(int a);
}
