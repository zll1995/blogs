package com.jk.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName PageController
 * @Description: TODO
 * @Author zjh
 * @Date 2019/11/15 10:06
 * @Version V1.0
 **/
@Controller
@RequestMapping("page")
public class PageController {

    //跳转到登陆页面  -----郑晋虎
    @RequestMapping("toLogin")
    public String toLogin(){
        return "login";
    }

    //跳转到注册页面  ------郑晋虎
    @RequestMapping("toRegister")
    public String toRegister(){
        return "register";
    }

    //跳转主页面
    @RequestMapping("toMain")
    public String toMain(){
        return "index";
    }

    //判断浏览器是否支持HTML5
    @RequestMapping("toIe")
    public String toIe(){
        return "ie";
    }

    //跳转修改个人资料页面
    @RequestMapping("toEditInfo")
    public String toEditInfo(){
        return "editUser";
    }
}
