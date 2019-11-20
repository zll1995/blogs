package com.jk.integral.controller;

import com.jk.integral.model.Integral;
import com.jk.integral.model.Store;
import com.jk.integral.service.IntegralService;
import com.jk.util.OSSClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName StoreController
 * @Description: TODO
 * @Author duanwf
 * @Date 2019/11/19 10:26
 * @Version V1.0
 **/
@Controller
@RequestMapping("integral")
public class IntegralController {
    @Autowired
    private IntegralService integralService;

    @RequestMapping("uploadCommImg")
    @ResponseBody
    public Map uploadImg(MultipartFile image)throws IOException {
        if (image == null || image.getSize() <= 0) {
            throw new IOException("file不能为空");
        }
        OSSClientUtil ossClient=new OSSClientUtil();
        String name = ossClient.uploadImg2Oss(image);
        String imgUrl = ossClient.getImgUrl(name);
        //String[] split = imgUrl.split("\\?");
        System.out.println("图片url："+imgUrl);
        Map map = new HashMap();
        map.put("imgUrl",imgUrl);
        return map;
    }


    //查询用户积分列表      -----段王峰
    @RequestMapping("queryIntegral")
    @ResponseBody
    public Map<String,Object> queryIntegral(Integral integral, Integer page, Integer rows){

        return integralService.queryIntegral(integral,page,rows);
    }

    //查询积分商城列表      -----段王峰
    @RequestMapping("queryStore")
    @ResponseBody
    public Map<String,Object> queryStore(Store store,Integer page,Integer rows){

        return integralService.queryStore(store,page,rows);
    }

    //添加积分商品信息      -----段王峰
    @RequestMapping("addStore")
    @ResponseBody
    public void addStore(Store store){
        integralService.addStore(store);
    }

    //删除积分商品信息      -----段王峰
    @RequestMapping("delStore")
    @ResponseBody
    public void delStore(Integer commId){
        integralService.delStore(commId);
    }

    //根据商品ID查询回显        -----段王峰
    @RequestMapping("queryStoreById")
    @ResponseBody
    public Store queryStoreById(Integer commId){
        return integralService.queryStoreById(commId);
    }

    //修改积分商品信息      -----段王峰
    @RequestMapping("updStore")
    @ResponseBody
    public void updStore(Store store){
        integralService.updStore(store);
    }

    //禁用用户积分    -----段王峰
    @RequestMapping("stopIntegral")
    @ResponseBody
    public void stopIntegral(Integer integralUserId){
        integralService.stopIntegral(integralUserId);
    }

    //解除禁用状态    -----段王峰
    @RequestMapping("recoverIntegral")
    @ResponseBody
    public void recoverIntegral(Integer integralUserId){
        integralService.recoverIntegral(integralUserId);
    }
}
