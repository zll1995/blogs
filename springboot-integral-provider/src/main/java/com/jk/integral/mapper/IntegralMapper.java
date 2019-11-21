package com.jk.integral.mapper;

import com.jk.integral.model.Integral;
import com.jk.integral.model.Store;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IntegralMapper {

    //查询用户剩余积分
    Integral queryIntegralById(Integer userId);

    //积分兑换
    void exchange(@Param("uid") Integer userId, @Param("commIntegral") Integer commIntegral);

    List<Store> queryCar();

    List<Store> queryBoutique();

    List<Store> queryHouseHome();

    List<Store> queryNumerical();

    List<Store> queryAppliance();

    Store queryCommById(Integer commId);
}
