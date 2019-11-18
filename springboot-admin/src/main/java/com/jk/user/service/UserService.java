package com.jk.user.service;

import com.jk.user.model.User;

import java.util.List;

/**
 * @ClassName UserService
 * @Description: TODO
 * @Author zjh
 * @Date 2019/11/18 20:26
 * @Version V1.0
 **/
public interface UserService {
    List<User> queryUserList();
}
