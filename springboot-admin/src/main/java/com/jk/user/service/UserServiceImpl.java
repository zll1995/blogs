package com.jk.user.service;

import com.jk.user.mapper.UserMapper;
import com.jk.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
