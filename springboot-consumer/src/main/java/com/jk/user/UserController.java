package com.jk.user;
import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.user.service.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Reference(version = "1.0")
    private UserService userService;
}
