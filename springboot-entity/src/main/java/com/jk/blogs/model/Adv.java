package com.jk.blogs.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Adv
 * @Description: TODO
 * @Author zjh
 * @Date 2019/11/19 11:38
 * @Version V1.0
 **/
@Data
public class Adv implements Serializable {

    private static final long serialVersionUID = 7698755719531279660L;

    private Integer advId;
    private String  advTitle;
    private String  advUrl;
    private String  advImg;
    private Integer typeId;
    private Integer topStatus;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date  topTime;

    private String advTypeName;
}
