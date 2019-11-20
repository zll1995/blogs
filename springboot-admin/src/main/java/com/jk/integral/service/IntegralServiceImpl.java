package com.jk.integral.service;

import com.jk.integral.mapper.IntegralMapper;
import com.jk.integral.model.Integral;
import com.jk.integral.model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName IntegralServiceImpl
 * @Description: TODO
 * @Author duanwf
 * @Date 2019/11/19 10:29
 * @Version V1.0
 **/
@Service
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

    //查询积分商城列表      -----段王峰
    @Override
    public Map<String, Object> queryStore(Store store, Integer page, Integer rows) {
        int sum = integralMapper.queryStoreSum(store);
        int start = (page-1)*rows;
        List<Store> storeList = integralMapper.queryStore(store,start,rows);
        Map<String,Object> storeMap = new HashMap<String, Object>();
        storeMap.put("total",sum);
        storeMap.put("rows",storeList);

        return storeMap;
    }

    //添加积分商品信息      -----段王峰
    @Override
    public void addStore(Store store) {
        integralMapper.addStore(store);
    }

    //删除积分商品信息      -----段王峰
    @Override
    public void delStore(Integer commId) {
        integralMapper.delStore(commId);
    }

    //根据商品ID查询回显        -----段王峰
    @Override
    public Store queryStoreById(Integer commId) {
        return integralMapper.queryStoreById(commId);
    }

    //修改积分商品信息      -----段王峰
    @Override
    public void updStore(Store store) {
        integralMapper.updStore(store);
    }

    //禁用用户积分    -----段王峰
    @Override
    public void stopIntegral(Integer integralUserId) {
        integralMapper.stopIntegral(integralUserId);
    }

    //解除禁用状态    -----段王峰
    @Override
    public void recoverIntegral(Integer integralUserId) {
        integralMapper.recoverIntegral(integralUserId);
    }
}
