package com.jk.integral.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Integral implements Serializable {
    private static final long serialVersionUID = -7949158349478664342L;

    private Integer integralId;         //积分id

    private Integer amount;             //积分数量

    private Integer integralUserId;     //用户id

    private String  integralUserName;   //用户名
}
