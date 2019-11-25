package com.jk.user.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jk.role.model.Role;
import com.jk.user.model.AdminUser;
import com.jk.user.model.User;
import com.jk.user.service.UserService;
import com.jk.utils.HttpClientUtil;
import com.jk.util.ExportExcel;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("export")
    public void export(HttpServletResponse response) {
        List<User> list= new ArrayList<User>();
        try {
            list = userService.queryUserList();
            //定义表格的标题
            String title ="异清轩博客用户信息";
            //定义列名
            String[] rowName={"Id","账号","昵称","手机号","性别","头像","生日"};
            //定义工具类要的数据
            List<Object[]>  dataList = new ArrayList<Object[]>();



            //循环数据把数据存放到 List<Object[]>
            for (User user:list) {
                Object[] obj=new Object[rowName.length];
                obj[0]=user.getUserId();
                obj[1]= user.getUsername();
                obj[2]=user.getNamed();
                obj[3]=user.getPhone();
                obj[4]=user.getUserSex();
                obj[5]=user.getHeadImg();
                obj[6]=user.getBirthday();
                dataList.add(obj);
            }
            ExportExcel exportExcel=new ExportExcel(title,rowName,dataList,response);
            exportExcel.export();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("queryAdminUser")
    @ResponseBody
    public List<AdminUser> queryAdminUser(){
        List<AdminUser> list = userService.queryAdminUser();
        return list;
    }

    @RequestMapping("queryAdminUserById")
    @ResponseBody
    public AdminUser queryAdminUserById(Integer id){
        return userService.queryAdminUserById(id);
    }

    @RequestMapping("updAdminUser")
    @ResponseBody
    public void updAdminUser(AdminUser adminUser){
        userService.updAdminUser(adminUser);
    }

    @RequestMapping("deleteUserByIds")
    @ResponseBody
    public void deleteUserByIds(String ids){
        userService.deleteUserByIds(ids);
    }

    @RequestMapping("queryUserOfRole")
    @ResponseBody
    public Integer queryUserOfRole(Integer id){
         return userService.queryUserOfRole(id);
    }

    @RequestMapping("updUserRole")
    @ResponseBody
    public void updUserRole(String ids,Integer roleId){
        userService.updUserRole(ids,roleId);
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

    @RequestMapping("login")
    public String login(String username, String password, Model model) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            subject.login(token);
            //登录成功
            //跳转到test.html
            return "redirect:/page/toMain";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg", "用户名不存在");
            return "index";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "密码错误");
            return "index";
        }
    }

    @RequestMapping("loginout")
    public String loginout() {
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
        } catch (Exception e) {
            return "redirect:/user/login";
        }
        return "index";
    }

    //修改密码
    @RequestMapping("updPwd")
    @ResponseBody
    public void updPwd(Integer id,String pwd){
        userService.updPwd(id,pwd);
    }
}
