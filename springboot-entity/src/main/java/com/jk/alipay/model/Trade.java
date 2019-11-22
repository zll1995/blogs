package com.jk.alipay.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName Trade
 * @Description: TODO
 * @Author WLBNS
 * @Date 2019/11/19 19:15
 * @Version V1.0
 **/
@Data
public class Trade implements Serializable {

    private static final long serialVersionUID = -2303832286916220700L;

    private String subject;         //订单编号
    private String out_trade_no;    //商户订单号
    private String trade_no;        //支付宝交易号
    private String total_amount;    //支付金额
    private String body;            //订单描述
    private Integer user_id;        //支付用户ID
    private Integer pay_type;       //购买类型：1.VIP，2.商品，3.其他
    private String create_time;     //订单创建时间
    private Integer buy_count;      //购买数量
}
