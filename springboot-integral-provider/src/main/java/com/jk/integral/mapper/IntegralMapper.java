package com.jk.integral.mapper;

import com.jk.integral.model.Integral;
import com.jk.integral.model.Store;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IntegralMapper {
    //查询用户积分列表总条数  -----段王峰
    int querySum(Integral integral);

    //查询用户积分列表       -----段王峰
    List<Integral> queryIntegral(@Param("i") Integral integral, @Param("s") int start, @Param("e") Integer rows);

    //禁用用户积分/解除禁用状态     -----段王峰
    void updIntegralStatus(@Param("userId") Integer integralUserId, @Param("flag") int flag);

    //查询积分商品总数
    int queryStoreSum(Store store);

    //查询积分商城列表      -----段王峰
    List<Store> queryStore(@Param("store") Store store, @Param("start") int start, @Param("end") Integer rows);

    //添加积分商品信息      -----段王峰
    void addStore(Store store);

    //删除积分商品信息      -----段王峰
    void delStore(Integer commId);

    //根据商品ID查询回显        -----段王峰
    Store queryStoreById(Integer commId);

    //修改积分商品信息      -----段王峰
    void updStore(Store store);

    //查询用户剩余积分
    Integral queryIntegralById(Integer userId);

    //积分兑换
    void exchange(@Param("uid") Integer userId, @Param("commIntegral") Integer commIntegral);
}
