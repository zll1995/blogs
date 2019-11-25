package com.jk.integral.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName UserComm
 * @Description: TODO
 * @Author duanwf
 * @Date 2019/11/22 11:34
 * @Version V1.0
 **/
@Data
public class UserComm implements Serializable {
    private static final long serialVersionUID = -6538916902903739164L;

    private Integer userCommId;

    private Integer userId;

    private Integer commId;

    private Integer goodsCount;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date    exchangeTime;

    private String  CommName;

    private Integer typeName;

    private String  CommImg;

    private Integer commIntegral;
}
