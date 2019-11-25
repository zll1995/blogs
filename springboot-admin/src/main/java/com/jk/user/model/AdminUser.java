package com.jk.user.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName AdminUser
 * @Description: TODO
 * @Author zjh
 * @Date 2019/11/20 11:55
 * @Version V1.0
 **/
@Data
public class AdminUser implements Serializable {
    private static final long serialVersionUID = 6748531080566861519L;

    private Integer userId; //用户Id

    private String username;   //用户名称

    private String password; //用户密码

    private String userImg;  //用户头像

    private Integer userSex;

    private String  rname;

    private Integer deptId;

    private String deptname;

    private String name;
}
