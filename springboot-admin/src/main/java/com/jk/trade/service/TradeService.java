package com.jk.trade.service;

import com.jk.trade.model.Trade;

import java.util.List;
import java.util.Map;

/**
 * @InterfaceName TradeService
 * @Description: TODO
 * @Author WLBNS
 * @Date 2019/11/20 12:09
 * @Version V1.0
 **/
public interface TradeService {

    Map<String,Object> queryTrade(Trade trade, Integer page, Integer rows);

    List<Map<String, Object>> TypeShow();

    List<Map<String, Object>> WeetMoneyByOne(Integer i);
}
