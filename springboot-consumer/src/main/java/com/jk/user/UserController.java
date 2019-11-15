package com.jk.user;
import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
    @Reference(version = "1.0")
    private UserService userService;



}
