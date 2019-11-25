package com.jk.adv.controller;

import com.jk.adv.model.Adv;
import com.jk.adv.model.AdvType;
import com.jk.adv.service.AdvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @ClassName AdvController
 * @Description: TODO
 * @Author zjh
 * @Date 2019/11/19 11:42
 * @Version V1.0
 **/
@Controller
@RequestMapping("adv")
public class AdvController {

    @Autowired
    private AdvService advService;

    @RequestMapping("queryAdvType")
    @ResponseBody
    public List<AdvType> queryAdvType(){
        return advService.queryAdvType();
    }

    @RequestMapping("deleteAdvTypeByIds")
    @ResponseBody
    public void deleteAdvTypeByIds(String ids){
        advService.deleteAdvByIds(ids);
    }

    @RequestMapping("addAdvType")
    @ResponseBody
    public void addAdvType(AdvType advType){
        advService.addAdvType(advType);
    }

    @RequestMapping("queryAdvTypeById")
    @ResponseBody
    public AdvType queryAdvTypeById(Integer id){
        return advService.queryAdvTypeById(id);
    }

    @RequestMapping("updAdvType")
    @ResponseBody
    public void updAdvType(AdvType advType){
        advService.updAdvType(advType);
    }

    @RequestMapping("queryAdv")
    @ResponseBody
    public List<Adv> queryAdv(){
         return advService.queryAdv();
    }

    @RequestMapping("deleteAdvByIds")
    @ResponseBody
    public void deleteAdvByIds(String ids){
        advService.deleteAdv(ids);
    }

    @RequestMapping("updateAdvTopStatus")
    @ResponseBody
    public void updateAdvTopStatus(Integer id,Integer flag){
        advService.updateAdvTopStatus(id,flag);
    }

    @RequestMapping("addAdv")
    @ResponseBody
    public void addAdv(Adv adv){
        advService.addAdv(adv);
    }

    @RequestMapping("queryAdvById")
    @ResponseBody
    public Adv queryAdvById(Integer id){
        return advService.queryAdvById(id);
    }
    @RequestMapping("updAdv")
    @ResponseBody
    public void updAdv(Adv adv){
        advService.updAdv(adv);
    }

}
