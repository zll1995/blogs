package com.jk.user.mapper;

import com.jk.user.model.User;

public interface UserMapper {
    User queryUserById(Integer userId);
}
