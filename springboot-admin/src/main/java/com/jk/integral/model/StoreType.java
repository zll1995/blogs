package com.jk.integral.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName StoreType
 * @Description: TODO
 * @Author duanwf
 * @Date 2019/11/20 15:07
 * @Version V1.0
 **/
@Data
public class StoreType implements Serializable {
    private static final long serialVersionUID = 9058125631435227779L;

    private Integer typeId;

    private String  typeName;
}
