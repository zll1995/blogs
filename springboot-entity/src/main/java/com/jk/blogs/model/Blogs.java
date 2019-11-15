package com.jk.blogs.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Blogs implements Serializable {

    private static final long serialVersionUID = -4638923736235342602L;

    private Integer  blogs_id;
    private String blogs_title;
    private String blogs_content;
    private String blogs_time;
    private Integer blogs_userid;
    private Integer blogs_like;
    private String blogs_img;
    private Integer blogs_look;
    private String blogs_url;

    private Integer blogs_status;
}
