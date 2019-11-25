package com.jk.integral.service;

import com.jk.integral.model.Integral;
import com.jk.integral.model.Store;
import com.jk.integral.model.StoreType;

import java.util.List;
import java.util.Map;

/**
 * @ClassName IntegralService
 * @Description: TODO
 * @Author duanwf
 * @Date 2019/11/19 10:28
 * @Version V1.0
 **/
public interface IntegralService {
    //查询用户积分列表  -----段王峰
    Map<String,Object> queryIntegral(Integral integral, Integer page, Integer rows);

    //查询积分商城列表      -----段王峰
    Map<String, Object> queryStore(Store store, Integer page, Integer rows);

    //添加积分商品信息      -----段王峰
    void addStore(Store store);

    //删除积分商品信息      -----段王峰
    void delStore(Store store);

    //根据商品ID查询回显        -----段王峰
    Store queryStoreById(Integer commId);

    //修改积分商品信息      -----段王峰
    void updStore(Store store);

    //查询商品类型
    List<StoreType> queryCommType();

    void upComm(Store store);

    void downComm(Store store);

    List queryUserComm();
}
