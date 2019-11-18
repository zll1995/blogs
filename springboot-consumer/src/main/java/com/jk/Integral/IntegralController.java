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

    //查询用户积分列表      -----段王峰
    @RequestMapping("queryIntegral")
    @ResponseBody
    public Map<String,Object> queryIntegral(Integral integral,Integer page,Integer rows){

        return integraService.queryIntegral(integral,page,rows);
    }

    //查询积分商城列表      -----段王峰
    @RequestMapping("queryStore")
    @ResponseBody
    public Map<String,Object> queryStore(Store store,Integer page,Integer rows){

        return integraService.queryStore(store,page,rows);
    }

    //添加积分商品信息      -----段王峰
    @RequestMapping("addStore")
    @ResponseBody
    public void addStore(Store store){
        integraService.addStore(store);
    }

    //删除积分商品信息      -----段王峰
    @RequestMapping("delStore")
    @ResponseBody
    public void delStore(Integer commId){
        integraService.delStore(commId);
    }

    //根据商品ID查询回显        -----段王峰
    @RequestMapping("queryStoreById")
    @ResponseBody
    public Store queryStoreById(Integer commId){
        return integraService.queryStoreById(commId);
    }

    //修改积分商品信息      -----段王峰
    @RequestMapping("updStore")
    @ResponseBody
    public void updStore(Store store){
        integraService.updStore(store);
    }

    //禁用用户积分/解除禁用状态     -----段王峰
    @RequestMapping("updIntegralStatus")
    @ResponseBody
    public void updIntegralStatus(Integer integralUserId,Integer flag){
        integraService.updIntegralStatus(integralUserId,flag);
    }

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
}
