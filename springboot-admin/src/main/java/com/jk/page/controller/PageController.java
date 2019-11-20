package com.jk.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName PageController
 * @Description: TODO
 * @Author zjh
 * @Date 2019/11/18 14:53
 * @Version V1.0
 **/
@Controller
@RequestMapping("page")
public class PageController {

    @RequestMapping("toMain")
    public String toMain(){
        return "main";
    }

    @RequestMapping("toShowUser")
    public String toShowUser(){
        return "showUser";
    }

    @RequestMapping("toTrade")
    public String toTrade(){
        return "ShowTrade";
    }
}
