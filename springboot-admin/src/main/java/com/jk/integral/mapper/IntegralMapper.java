package com.jk.integral.mapper;

import com.jk.integral.model.Integral;
import com.jk.integral.model.Store;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName IntegralMapper
 * @Description: TODO
 * @Author duanwf
 * @Date 2019/11/19 10:29
 * @Version V1.0
 **/
public interface IntegralMapper {
    //查询用户积分列表总条数  -----段王峰
    int querySum(Integral integral);

    //查询用户积分列表       -----段王峰
    List<Integral> queryIntegral(@Param("i") Integral integral, @Param("s") int start, @Param("e") Integer rows);

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

    //禁用用户积分    -----段王峰
    void stopIntegral(Integer integralUserId);

    //解除禁用状态    -----段王峰
    void recoverIntegral(Integer integralUserId);
}
