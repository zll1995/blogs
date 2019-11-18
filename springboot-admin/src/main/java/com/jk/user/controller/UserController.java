package com.jk.user.controller;

import com.jk.user.model.User;
import com.jk.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName UserController
 * @Description: TODO
 * @Author zjh
 * @Date 2019/11/18 20:26
 * @Version V1.0
 **/
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("queryUserList")
    @ResponseBody
    public List<User> queryUserList(){
        return userService.queryUserList();
    }
}
