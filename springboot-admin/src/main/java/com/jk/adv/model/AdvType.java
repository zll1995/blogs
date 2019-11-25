package com.jk.adv.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName AdvType
 * @Description: TODO
 * @Author zjh
 * @Date 2019/11/19 11:41
 * @Version V1.0
 **/
@Data
public class AdvType implements Serializable {
    private static final long serialVersionUID = 7482639997329976264L;

    private Integer advTypeId;
    private String  advTypeName;
}
