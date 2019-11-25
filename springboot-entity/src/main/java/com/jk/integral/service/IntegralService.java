package com.jk.integral.service;

import com.jk.integral.model.Integral;
import com.jk.integral.model.Store;
import com.jk.integral.model.UserComm;
import com.jk.user.model.User;

import java.util.List;
import java.util.Map;

public interface IntegralService {

    //查询用户剩余积分
    Integral queryIntegralById(Integer userId);

    //积分兑换
    void exchange(Integer userId, Integer commIntegral);

    List<Store> queryCar();

    List<Store> queryBoutique();

    List<Store> queryHouseHome();

    List<Store> queryNumerical();

    List<Store> queryAppliance();

    Store queryCommById(Integer commId);

    void addUserComm(Integer nowJf, Integer goodsCount, Integer commId, Integer userId);

    List queryMyStore(Integer userId);

    User initUserImg(Integer userId);
}
