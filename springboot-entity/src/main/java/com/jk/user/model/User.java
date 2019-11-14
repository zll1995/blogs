package com.jk.user.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 5034426654100868124L;

    private Integer userId;

    private String userName;

    private String password;

    private String headImg;

    private String phone;

    private String name; //博客昵称

    private String blogName; //博客标题

    private String blogUrl;  //博客地址

    private String email;  //电子邮箱

}
