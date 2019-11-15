package com.jk.integral.service;
import com.alibaba.dubbo.config.annotation.Service;
import com.jk.integral.mapper.IntegralMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Service(version = "1.0")
public class IntegralServiceImpl implements IntegralService{
    @Autowired
    private IntegralMapper integralMapper;
}
