package com.jk.user;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jk.user.model.User;
import com.jk.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.UUID;


@Controller
@RequestMapping("user")
public class UserController {
    @Reference(version = "1.0")
    private UserService userService;

    @RequestMapping("queryUserByName")
    @ResponseBody
    public String queryUserByName(User user) {
        User regUser = userService.queryUserByName(user.getUsername());
        if (regUser != null) {
            return "fail";
        }
        return "success";
    }

    /*
     * 查询手机号是否存在
     * */
    @RequestMapping("queryPhone")
    @ResponseBody
    public String queryPhone(User user) {
        User regUser = userService.queryPhone(user.getPhone());
        if (regUser != null) {
            return "fail";
        }
        return "success";
    }


    @RequestMapping("saveUser")
    public String saveUser(User user) {
        userService.saveUser(user);
        return "login";
    }

    @RequestMapping("login")
    @ResponseBody
    public int regUser(User user, HttpServletRequest request) {
        //首先查询账号是否存在
        User reUser = userService.queryUserByName(user.getUsername());
        //判断查询到的对象是否为空
        if (reUser == null) {
            //此时账号不存在
            return 1;
        } else {
            //如果账号存在，则判断密码是否正确
            if (reUser.getPassword() != null && !"".equals(reUser.getPassword()) && reUser.getPassword().equals(user.getPassword())) {
                //账号密码正确，登录成功
                //将登录对象存入session
                request.getSession().setAttribute("loginUser", reUser);
                return 2;//代表登录成功
            } else {
                return 3;//代表密码错误
            }
        }
    }


    @RequestMapping("hqyzm")
    @ResponseBody
    public int jsUser(User user) {
        //2.发送短信验证码
        String url = "https://api.netease.im/sms/sendcode.action";
        //header的参数
        HashMap<String, Object> header = new HashMap<String, Object>();
        String nonce = UUID.randomUUID().toString();//随机数（最大长度128个字符
        String curTime = String.valueOf(System.currentTimeMillis() / 1000);//当前UTC时间戳，从1970年1月1日0点0 分0 秒开始到现在的秒数(String)
        header.put("AppKey", "453f1cb3c63748f4eb1ef47147d2b57e");//开发者平台分配的appkey
        header.put("Nonce", nonce);//随机数（最大长度128个字符
        header.put("CurTime", curTime);//当前UTC时间戳，从1970年1月1日0点0 分0 秒开始到现在的秒数(String)
        //SHA1(AppSecret + Nonce + CurTime)，三个参数拼接的字符串，进行SHA1哈希计算，转化成16进制字符(String，小写)
        String appSecret = "82662da49ebf";
        String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce, curTime);
        header.put("CheckSum", checkSum);

        //body的参数
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("mobile", user.getPhone());//手机号
        params.put("templateid", 14831182);//模板编号(如不指定则使用配置的默认模版)
        //验证码
        long code = Math.round(Math.random() * 899999 + 100000);
        params.put("authCode", code);//客户自定义验证码，长度为4～10个数字

        String str = HttpClientUtil.post3(url, params, header);
        JSONObject obj = JSON.parseObject(str);
        int recode = obj.getIntValue("code");
        if (recode != 200) {
            return recode;
        }

        return recode;


    }

}