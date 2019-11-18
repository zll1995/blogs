package com.jk.integral.service;

import com.jk.integral.model.Integral;
import com.jk.integral.model.Store;

import java.util.Map;

public interface IntegralService {
    //查询用户积分列表  -----段王峰
    Map<String,Object> queryIntegral(Integral integral, Integer page, Integer rows);

    //禁用用户积分/解除禁用状态        -----段王峰
    void updIntegralStatus(Integer integralUserId, Integer flag);

    //查询积分商城列表      -----段王峰
    Map<String, Object> queryStore(Store store, Integer page, Integer rows);

    //添加积分商品信息      -----段王峰
    void addStore(Store store);

    //删除积分商品信息      -----段王峰
    void delStore(Integer commId);

    //根据商品ID查询回显        -----段王峰
    Store queryStoreById(Integer commId);

    //修改积分商品信息      -----段王峰
    void updStore(Store store);

    //查询用户剩余积分
    Integral queryIntegralById(Integer userId);

    //积分兑换
    void exchange(Integer userId, Integer commIntegral);
}
