package com.jk.integral.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Integral implements Serializable {
    private static final long serialVersionUID = -7949158349478664342L;

    private Integer integralId;         //积分id

    private Integer integralAmount;             //积分数量

    private Integer integralUserId;     //用户id

    private String  integralUserName;   //用户名

    private String  integralPhone;       //用户手机号

    private Integer startAmount;        //最小积分数

    private Integer endAmount;          //最大积分数
}
