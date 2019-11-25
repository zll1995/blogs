package com.jk.integral.service;

import com.jk.integral.mapper.IntegralMapper;
import com.jk.integral.model.Integral;
import com.jk.integral.model.Store;
import com.jk.integral.model.StoreType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

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
        String key = "store"+store.getCommType();
        Boolean hasKey = redisTemplate.hasKey(key);
        if(hasKey){
            redisTemplate.delete(key);
        }
        integralMapper.addStore(store);
    }

    //删除积分商品信息      -----段王峰
    @Override
    public void delStore(Store store) {
        String key = "store"+store.getCommType();
        Boolean hasKey = redisTemplate.hasKey(key);
        if(hasKey){
            redisTemplate.delete(key);
        }
        integralMapper.delStore(store.getCommId());
    }

    //根据商品ID查询回显        -----段王峰
    @Override
    public Store queryStoreById(Integer commId) {
        return integralMapper.queryStoreById(commId);
    }

    //修改积分商品信息      -----段王峰
    @Override
    public void updStore(Store store) {
        String key = "store"+store.getCommType();
        Boolean hasKey = redisTemplate.hasKey(key);
        if(hasKey){
            redisTemplate.delete(key);
        }
        integralMapper.updStore(store);
    }

    //查询商品类型
    @Override
    public List<StoreType> queryCommType() {
        return integralMapper.queryCommType();
    }

    @Override
    public void upComm(Store store) {
        String key = "store"+store.getCommType();
        Boolean hasKey = redisTemplate.hasKey(key);
        if(hasKey){
            redisTemplate.delete(key);
        }
        integralMapper.upComm(store.getCommId());
    }

    @Override
    public void downComm(Store store) {
        String key = "store"+store.getCommType();
        Boolean hasKey = redisTemplate.hasKey(key);
        if(hasKey){
            redisTemplate.delete(key);
        }
        integralMapper.downComm(store.getCommId());
    }

    @Override
    public List queryUserComm() {
        return integralMapper.queryUserComm();
    }
}
