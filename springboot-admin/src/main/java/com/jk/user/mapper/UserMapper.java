package com.jk.user.mapper;

import com.jk.user.model.User;

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
}
