package com.jk.user.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.user.mapper.UserMapper;
import com.jk.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;

@Service(version = "1.0")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUserById(Integer userId) {
        return userMapper.queryUserById(userId);
    }
}
