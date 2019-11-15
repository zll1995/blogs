package com.jk.integral.mapper;

import com.jk.integral.model.Integral;

import java.util.List;

public interface IntegralMapper {
    //查询用户积分列表总条数  -----段王峰
    int querySum(Integral integral);

    //查询用户积分列表       -----段王峰
    List<Integral> queryIntegral(Integral integral, int start, Integer rows);
}
