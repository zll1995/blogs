package com.jk.integral.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Store
 * @Description: TODO
 * @Author duanwf
 * @Date 2019/11/18 18:30
 * @Version V1.0
 **/
@Data
public class Store implements Serializable {

    private static final long serialVersionUID = 7113800974492832221L;

    private Integer commId;     //积分商品ID

    private String  commName;   //积分商品名称

    private Integer commIntegral;   //商品兑换所需积分

    private String  commImg;        //积分图片

    private Integer commCount;      //商品剩余库存

    private String  issuer;         //商品发布者

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date    commDate;       //商品上传时间
}
