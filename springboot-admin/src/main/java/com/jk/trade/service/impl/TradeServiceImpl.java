package com.jk.trade.service.impl;

import com.jk.trade.mapper.TradeMapper;
import com.jk.trade.model.Trade;
import com.jk.trade.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName TradeServiceImpl
 * @Description: TODO
 * @Author WLBNS
 * @Date 2019/11/20 12:10
 * @Version V1.0
 **/
@Service
public class TradeServiceImpl implements TradeService {
            @Autowired
            private TradeMapper tradeMapper;
    @Override
    public Map<String,Object> queryTrade(Trade trade, Integer page, Integer rows) {
        Integer sum = tradeMapper.queryTradeSum(trade);
        Integer start = (page-1)*rows;
        List<Trade> list = tradeMapper.queryTrade(trade,start,rows);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("rows",list);
        map.put("total",sum);
        return map;
    }

    @Override
    public List<Map<String, Object>> TypeShow() {
        return tradeMapper.TypeShow();
    }

    @Override
    public List<Map<String, Object>> WeetMoneyByOne(Integer i) {
        return tradeMapper.WeetMoneyByOne(i);
    }
}
