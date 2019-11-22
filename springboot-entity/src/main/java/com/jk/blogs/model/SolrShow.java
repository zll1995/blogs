package com.jk.blogs.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * @ClassName SolrShow
 * @Description: TODO
 * @Author WLBNS
 * @Date 2019/11/17 16:40
 * @Version V1.0
 **/
@Data
public class SolrShow implements Serializable {

    private static final long serialVersionUID = -4021664828175026413L;

    private Integer id;
    private String title;
    private String content;
    private String nickname;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String time;
    private Integer look;
    private String url;
    private String img;
}
