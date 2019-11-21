package com.jk.Integral;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.integral.model.Integral;
import com.jk.integral.model.Store;
import com.jk.integral.service.IntegralService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
    @RequestMapping("buyComm")
    @ResponseBody
    public void buyComm(Integer spjf, Integer goodsCount, HttpServletRequest request){
        request.getSession().getAttribute("login");

    }

    //查询汽车周边商城      -----段王峰
    @RequestMapping("queryCar")
    @ResponseBody
    public List<Store> queryCar(){

        return integraService.queryCar();
    }

    //查询精品推荐
    @RequestMapping("queryBoutique")
    @ResponseBody
    public List<Store> queryBoutique(){

        return integraService.queryBoutique();
    }

    //查询家居用品
    @RequestMapping("queryHouseHome")
    @ResponseBody
    public List<Store> queryHouseHome(){

        return integraService.queryHouseHome();
    }

    //查询手机数码
    @RequestMapping("queryNumerical")
    @ResponseBody
    public List<Store> queryNumerical(){

        return integraService.queryNumerical();
    }

    //查询家用电器
    @RequestMapping("queryAppliance")
    @ResponseBody
    public List<Store> queryAppliance(){

        return integraService.queryAppliance();
    }

    @RequestMapping("queryCommById")
    @ResponseBody
    public Store queryCommById(Integer commId){
        Store store = integraService.queryCommById(commId);

        return store;
    }
}
