package com.jk.user.service;

import com.jk.user.model.User;

public interface UserService {

    User queryUserById(Integer userId);

    User queryUserByName(String username);

    void saveUser(User user);

    User queryPhone(String phone);
}
