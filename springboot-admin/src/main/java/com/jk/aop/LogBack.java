package com.jk.aop;

import lombok.Data;
import org.aspectj.lang.Signature;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @ClassName logBack
 * @Deacription TODO
 * @Author liushuxin
 * @Date 2019/11/22 20:02
 * @Version 1.0
 **/
@Data
@Document(collection = "blogLog")
public class LogBack {
    @Id
    private String id;
    private String method;
    private String parmes;
    private String rvalue;
    private String exception;


}
