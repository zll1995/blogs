package com.jk.alipay.service;

import com.jk.alipay.model.Trade;

/**
 * @InterfaceName TradeService
 * @Description: TODO
 * @Author WLBNS
 * @Date 2019/11/19 19:23
 * @Version V1.0
 **/
public interface TradeService {

    void saveTrade(Trade trade);

    void RenewVIP(Integer user_id, Integer buy_count);
}
