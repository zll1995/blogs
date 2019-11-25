package com.jk.integral.service;
import com.alibaba.dubbo.config.annotation.Service;
import com.jk.integral.mapper.IntegralMapper;
import com.jk.integral.model.Integral;
import com.jk.integral.model.Store;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(version = "1.0")
public class IntegralServiceImpl implements IntegralService{
    @Autowired
    private IntegralMapper integralMapper;

    //查询用户剩余积分
    @Override
    public Integral queryIntegralById(Integer userId) {
        return integralMapper.queryIntegralById(userId);
    }

    //积分兑换
    @Override
    public void exchange(Integer userId, Integer commIntegral) {
        integralMapper.exchange(userId,commIntegral);
        //integralMapper.updCommCount();
    }

    @Override
    public List<Store> queryCar() {
        return integralMapper.queryCar();
    }

    @Override
    public List<Store> queryBoutique() {
        return integralMapper.queryBoutique();
    }

    @Override
    public List<Store> queryHouseHome() {
        return integralMapper.queryHouseHome();
    }

    @Override
    public List<Store> queryNumerical() {
        return integralMapper.queryNumerical();
    }

    @Override
    public List<Store> queryAppliance() {
        return integralMapper.queryAppliance();
    }

    @Override
    public Store queryCommById(Integer commId) {
        return integralMapper.queryCommById(commId);
    }
}
