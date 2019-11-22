package com.jk.utils;

import com.jk.alipay.mapper.TradeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName Scheduler
 * @Description: TODO
 * @Author WLBNS
 * @Date 2019/11/20 11:10
 * @Version V1.0
 **/
@Component
public class Scheduler {
            @Autowired
            private TradeMapper tradeMapper;
    //设置时间格式
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    //该定时器设置为每天凌晨多2秒执行一次
    @Scheduled(cron = "2 0 0 * * ?")
    public void testTasksA() {
        //删除过期会员信息
        tradeMapper.deleteExpireVip();
    }


}
