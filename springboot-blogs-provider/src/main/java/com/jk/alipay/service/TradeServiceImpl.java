package com.jk.alipay.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.jk.alipay.mapper.TradeMapper;
import com.jk.alipay.model.Trade;
import com.jk.integral.model.Integral;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName TradeServiceImpl
 * @Description: TODO
 * @Author WLBNS
 * @Date 2019/11/19 19:38
 * @Version V1.0
 **/
@Service(version = "1.0")
public class TradeServiceImpl implements TradeService{
            @Autowired
            private TradeMapper tradeMapper;
    @Override
    public void saveTrade(Trade trade) {
        tradeMapper.saveTrade(trade);
    }

    @Override
    public void RenewVIP(Integer user_id, Integer buy_count) {
        Integer cc = tradeMapper.queryVIPById(user_id);
        if(cc!=0){
            tradeMapper.updateVIPEndTime(user_id,buy_count);
        }else{
            tradeMapper.addVIP(user_id,buy_count);
        }
    }

    @Override
    public void addIntegral(Integer user_id, Integer buy_count) {
        Integral inte = tradeMapper.queryIntegralByUserId(user_id);
        if(inte==null){
            tradeMapper.addIntegral(user_id,buy_count);
        }
        tradeMapper.updIntegral(user_id,buy_count);
    }
}
