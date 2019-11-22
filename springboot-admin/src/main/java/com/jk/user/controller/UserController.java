package com.jk.user.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jk.user.model.User;
import com.jk.user.service.UserService;
import com.jk.utils.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
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
    @RequestMapping("weather")
    @ResponseBody
    public static HashMap<String, Object> DailySentence(){
        String Key = "Weather";
        String url = "http://api.help.bj.cn/apis/weather?id=101110101";
        String string = HttpClientUtil.get(url);
        JSONObject jo = JSON.parseObject(string);
        HashMap<String,Object> map1 = new HashMap<String,Object>();
        map1.put("city",jo.get("city"));
        map1.put("temp",jo.get("temp"));
        map1.put("wd",jo.get("wd"));
        map1.put("wdforce",jo.get("wdforce"));
        map1.put("uptime",jo.get("uptime"));
        map1.put("weather",jo.get("weather"));
        map1.put("humidity",jo.get("humidity"));
        map1.put("today",jo.get("today"));
        return map1;
    }
}
