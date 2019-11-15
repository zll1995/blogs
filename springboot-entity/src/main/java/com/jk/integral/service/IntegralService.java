package com.jk.integral.service;

import com.jk.integral.model.Integral;

import java.util.Map;

public interface IntegralService {
    //查询用户积分列表  -----段王峰
    Map<String,Object> queryIntegral(Integral integral, Integer page, Integer rows);
}
