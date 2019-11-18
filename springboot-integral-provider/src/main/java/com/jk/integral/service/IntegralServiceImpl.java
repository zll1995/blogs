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

    //禁用用户积分/解除禁用状态     -----段王峰
    @Override
    public void updIntegralStatus(Integer integralUserId, Integer flag) {
        //flag为0的时候,为禁用该用户的积分
        if(flag==0){
            integralMapper.updIntegralStatus(integralUserId,1);
        //flag为1的时候,将该用户的积分恢复正常使用
        }else if(flag==1){
            integralMapper.updIntegralStatus(integralUserId,0);
        }
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
}
