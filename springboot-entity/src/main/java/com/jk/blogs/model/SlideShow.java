package com.jk.blogs.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName SlideShow
 * @Description: TODO
 * @Author WLBNS
 * @Date 2019/11/15 19:08
 * @Version V1.0
 **/
@Data
public class SlideShow implements Serializable {

    private static final long serialVersionUID = 2337199578350894119L;

    private Integer slideshow_id;
    private String slideshow_title;
    private String slideshow_url;
    private String slideshow_img;
}
