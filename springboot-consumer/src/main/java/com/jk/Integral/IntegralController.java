package com.jk.Integral;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.integral.model.Integral;
import com.jk.integral.model.Store;
import com.jk.integral.service.IntegralService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("integral")
public class IntegralController {
    @Reference(version = "1.0")
    private IntegralService integraService;

    //查询用户剩余积分
    @RequestMapping("queryIntegralById")
    @ResponseBody
    public Integral queryIntegralById(Integer userId){
        return integraService.queryIntegralById(userId);
    }

    //积分兑换
    @RequestMapping("exchange")
    @ResponseBody
    public String exchange(Integer userId,Integer amount,Integer commIntegral){
        //判断用户积分是否够兑换商品
        if(amount<commIntegral){
            return "Lack of integral";
        }else {
            integraService.exchange(userId,commIntegral);
            return "success";
        }
    }

    //查询汽车周边商城      -----段王峰
    @RequestMapping("queryCar")
    @ResponseBody
    public List<Store> queryCar(){

        return integraService.queryCar();
    }

    //查询
    @RequestMapping("queryBoutique")
    @ResponseBody
    public List<Store> queryBoutique(){

        return integraService.queryBoutique();
    }
}
