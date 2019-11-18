package com.jk.user.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.jk.user.mapper.UserMapper;
import com.jk.user.model.User;
import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.springframework.beans.factory.annotation.Autowired;

@Service(version = "1.0")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    /*
    * 登录根据用户名查看用户是否存在
    * */
    @Override
    public User queryUserByName(String username) {
        return userMapper.queryUserByName(username);
    }
}
