package com.jk.integral.service;

import com.jk.integral.model.Integral;
import com.jk.integral.model.Store;

import java.util.List;
import java.util.Map;

public interface IntegralService {

    //查询用户剩余积分
    Integral queryIntegralById(Integer userId);

    //积分兑换
    void exchange(Integer userId, Integer commIntegral);

    List<Store> queryCar();

    List<Store> queryBoutique();
}
