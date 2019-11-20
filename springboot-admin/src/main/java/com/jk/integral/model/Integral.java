package com.jk.integral.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Integral implements Serializable {

    private static final long serialVersionUID = -8450071654172417533L;

    private Integer integralId;         //积分id

    private Integer amount;             //积分数量

    private Integer integralStatus;     //积分状态(0:正常,1:禁用)

    private Integer integralUserId;     //用户id

    private String  integralName;       //用户姓名

    private String  integralUserName;   //用户账号

    private String  integralPhone;       //用户手机号

    private Integer integralUserSex;     //用户性别
}
