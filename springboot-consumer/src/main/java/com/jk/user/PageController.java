package com.jk.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    //跳转搜索结果页面
    @RequestMapping("ToSearchPage")
    public String ToSearchPage(){
        return "SearchPage";
    }

    //跳转403页面
    @RequestMapping("noLogin")
    public String noLogin(){
        return "403";
    }

    //跳转积分商城页面
    @RequestMapping("toIntegralStore")
    public String toIntegralStore(){
        return "integralStore";
    }

    //跳转会员充值页面
    @RequestMapping("toVip")
    public String toVip(){
        return "ShowVip";
    }

    //跳转展示博客页面
    @RequestMapping("toShowInfoPage")
    public String toShowInfoPage(String id, Model model){
        model.addAttribute("id",id);
            return "ShowBlogsPage";
    }

    //跳转展示用户信息页面
    @RequestMapping("toShowUserInfo")
    public String toShowUserInfo(String id){
        return "ShowUserInfo";
    }
    //跳转商品详情页面
    @RequestMapping("toStoreInfo")
    public String toStoreInfo(Integer commId, Model model){
        model.addAttribute("commId",commId);
        return "storeInfo";
    }

    @RequestMapping("toaddimg")
    public String toaddimg(){
        return "addimg";
    }

    //跳转手机号登录页面
    @RequestMapping("toPhone")
    public String toPhone(){
        return "toPhone";
    }




}
