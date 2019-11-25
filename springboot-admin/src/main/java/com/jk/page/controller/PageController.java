package com.jk.page.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @RequestMapping("toShowAdvType")
    public String toShowAdvType(){
        return "showAdvType";
    }
    @RequestMapping("toAddAdvType")
    public String toAddAdvType(){
        return "addAdvType";
    }
    @RequestMapping("toShowAdv")
    public String toShowAdv(){
        return "showAdv";
    }
    @RequestMapping("toAddAdv")
    public String toAddAdv(){
        return "addAdv";
    }

    @RequestMapping("toUpdAdv")
    public String toUpdAdv(){
        return "updAdv";
    }

    @RequestMapping("toShowAdmin")
    public String toShowAdmin(){
        return "showAdmin";
    }

    @RequestMapping("toUpdAdminUser")
    public String toUpdAdminUser(){
        return "updAdminUser";
    }

    @RequestMapping("toShowDept")
    public String toShowDept(){
        return "showDept";
    }

    @RequestMapping("toAddDept")
    public String toAddDept(){
        return "addDept";
    }

    @RequestMapping("toShowRole")
    public String toShowRole(){
        return "showRole";
    }

    @RequestMapping("toAddRole")
    public String toAddRole(){
        return "addRole";
    }

    @RequestMapping("toUpdateRole")
    public String toUpdateRole(){
        return "updateUserRole";
    }

    @RequestMapping("queryRoleTree")
    public String queryRoleTree(Integer roleId, Model model){
        model.addAttribute("roleId",roleId);
        return "nopowerr";
    }

    @RequestMapping("toIndex")
    public String toIndex(){
        return "index";
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

    @RequestMapping("toUpdPwd")
    public String toUpdPwd(){
        return "updPwd";
    }
}
