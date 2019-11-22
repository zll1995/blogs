package com.jk.user.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 5034426654100868124L;

    private Integer userId; //用户Id

    private String username;   //用户名称

    private String password; //用户密码

    private String headImg;  //用户头像

    private String phone; //用户手机号

    private String named; //博客昵称

    private String blogName; //博客标题

    private String blogUrl;  //博客地址

    private String email;  //电子邮箱

    private Integer userSex;

}
