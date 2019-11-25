package com.jk.user.model;

import lombok.Data;

/**
 * @ClassName Member
 * @Description: TODO
 * @Author WLBNS
 * @Date 2019/11/20 9:19
 * @Version V1.0
 **/
@Data
public class Member {
    private Integer vip_id;
    private Integer user_id;
    private String vip_createtime;
    private String vip_endtime;
}
