package com.jk.trade.controller;

import com.jk.trade.model.Trade;
import com.jk.trade.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @ClassName tradeController
 * @Description: TODO
 * @Author WLBNS
 * @Date 2019/11/20 12:08
 * @Version V1.0
 **/
@Controller
@RequestMapping("trade")
public class tradeController {
            @Autowired
            private TradeService tradeService;
    @RequestMapping("queryTrade")
    @ResponseBody
    public Map<String,Object> queryTrade(Trade trade,Integer page,Integer rows){
        Map<String, Object> map = tradeService.queryTrade(trade, page, rows);
        return map;
    }
}
