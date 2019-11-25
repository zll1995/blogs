package com.jk.integral.service;
import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.jk.integral.mapper.IntegralMapper;
import com.jk.integral.model.Integral;
import com.jk.integral.model.Store;
import com.jk.integral.model.UserComm;
import com.jk.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service(version = "1.0")
public class IntegralServiceImpl implements IntegralService{
    @Autowired
    private IntegralMapper integralMapper;

    @Autowired
    private RedisTemplate<String ,String> redisTemplate;

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
        String key = "store5";
        List<Store> stores = new ArrayList<>();
        Boolean hasKey = redisTemplate.hasKey(key);
        if(hasKey){
            String s = redisTemplate.opsForValue().get(key);
            stores = JSON.parseArray(s, Store.class);
        }else {
            stores = integralMapper.queryCar();
            redisTemplate.opsForValue().set(key,JSON.toJSONString(stores));
            redisTemplate.expire(key,12,TimeUnit.HOURS);
        }
        return stores;
    }

    @Override
    public List<Store> queryBoutique() {
        String key = "store1";
        List<Store> list = new ArrayList<Store>();
        Boolean hasKey = redisTemplate.hasKey(key);
        if(hasKey){
            String s = redisTemplate.opsForValue().get(key);
            List<Store> jsonArray = JSON.parseArray(s,Store.class);
            list = jsonArray;
            System.err.println("=============走缓存");
        }else{
            list = integralMapper.queryBoutique();;
            redisTemplate.opsForValue().set(key,JSON.toJSONString(list));
            redisTemplate.expire(key,12,TimeUnit.HOURS);
            System.err.println("=============走数据库");
        }

        return list;
    }

    @Override
    public List<Store> queryHouseHome() {
        String key = "store2";
        List<Store> list = new ArrayList<Store>();
        Boolean hasKey = redisTemplate.hasKey(key);
        if(hasKey){
            String s = redisTemplate.opsForValue().get(key);
            list = JSON.parseArray(s,Store.class);
        }else{
            list = integralMapper.queryHouseHome();;
            redisTemplate.opsForValue().set(key,JSON.toJSONString(list));
            redisTemplate.expire(key,12,TimeUnit.HOURS);
        }

        return list;
    }

    @Override
    public List<Store> queryNumerical() {
        String key = "store4";
        List<Store> list = new ArrayList<Store>();
        Boolean hasKey = redisTemplate.hasKey(key);
        if(hasKey){
            String s = redisTemplate.opsForValue().get(key);
            list = JSON.parseArray(s,Store.class);
        }else{
            list = integralMapper.queryNumerical();;
            redisTemplate.opsForValue().set(key,JSON.toJSONString(list));
            redisTemplate.expire(key,12,TimeUnit.HOURS);
        }

        return list;
    }

    @Override
    public List<Store> queryAppliance() {
        String key = "store3";
        List<Store> list = new ArrayList<Store>();
        Boolean hasKey = redisTemplate.hasKey(key);
        if(hasKey){
            String s = redisTemplate.opsForValue().get(key);
            list = JSON.parseArray(s,Store.class);
        }else{
            list = integralMapper.queryAppliance();;
            redisTemplate.opsForValue().set(key,JSON.toJSONString(list));
            redisTemplate.expire(key,12,TimeUnit.HOURS);
        }

        return list;
    }

    @Override
    public Store queryCommById(Integer commId) {
        return integralMapper.queryCommById(commId);
    }

    @Override
    public void addUserComm(Integer nowJf, Integer goodsCount, Integer commId,Integer userId) {
        integralMapper.addUserComm(userId,commId,goodsCount);
        integralMapper.updGoodsCount(goodsCount,commId);
        integralMapper.updUserIntegral(nowJf,userId);
    }

    @Override
    public List queryMyStore(Integer userId) {
        return integralMapper.queryMyStore(userId);
    }

    @Override
    public User initUserImg(Integer userId) {
        return integralMapper.initUserImg(userId);
    }
}
