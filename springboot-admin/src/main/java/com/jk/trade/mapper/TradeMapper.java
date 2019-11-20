package com.jk.trade.mapper;

import com.jk.trade.model.Trade;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @InterfaceName TradeMapper
 * @Description: TODO
 * @Author WLBNS
 * @Date 2019/11/20 12:10
 * @Version V1.0
 **/
public interface TradeMapper {

    Integer queryTradeSum(Trade t);

    List<Trade> queryTrade(@Param("trade") Trade trade, @Param("s")Integer start, @Param("r")Integer rows);
}
