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

    @RequestMapping("toShowIntegral")
    public String toShowIntegral(){
        return "showIntegral";
    }

    @RequestMapping("toShowStore")
    public String toShowStore(){
        return "showStore";
    }

    @RequestMapping("toEditStore")
    public String toEditStore(){
        return "editStore";
    }

    @RequestMapping("toAddStore")
    public String toAddStore(){
        return "addStore";
    }

    @RequestMapping("toTrade")
    public String toTrade(){
        return "ShowTrade";
    }

    @RequestMapping("toViewAnalysis")
    public String toViewAnalysis(){
        return "TradeView";
    }

    @RequestMapping("toUserComm")
    public String toUserComm(){
        return "userComm";
    }
}
