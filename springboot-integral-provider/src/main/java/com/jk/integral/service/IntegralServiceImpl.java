package com.jk.integral.service;
import com.alibaba.dubbo.config.annotation.Service;
import com.jk.integral.mapper.IntegralMapper;
import com.jk.integral.model.Integral;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(version = "1.0")
public class IntegralServiceImpl implements IntegralService{
    @Autowired
    private IntegralMapper integralMapper;

    //查询用户积分列表  -----段王峰
    @Override
    public Map<String, Object> queryIntegral(Integral integral, Integer page, Integer rows) {
        int sum = integralMapper.querySum(integral);
        int start = (page-1)*rows;
        List<Integral> integralsList = integralMapper.queryIntegral(integral,start,rows);
        Map<String,Object> integralMap = new HashMap<String, Object>();
        integralMap.put("total",sum);
        integralMap.put("rows",integralsList);

        return integralMap;
    }
}
