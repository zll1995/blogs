package com.jk.alipay.mapper;

import com.jk.alipay.model.Trade;
import org.apache.ibatis.annotations.Param;

/**
 * @InterfaceName TradeMapper
 * @Description: TODO
 * @Author WLBNS
 * @Date 2019/11/19 19:50
 * @Version V1.0
 **/
public interface TradeMapper {

    void saveTrade(Trade trade);

    Integer queryVIPById(Integer id);

    void addVIP(@Param("id") Integer user_id,@Param("count") Integer buy_count);

    void updateVIPEndTime(@Param("id") Integer user_id,@Param("count") Integer buy_count);

    void deleteExpireVip();
}
