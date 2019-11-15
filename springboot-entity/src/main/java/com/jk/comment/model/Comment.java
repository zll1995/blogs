package com.jk.comment.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class Comment implements Serializable {
    private static final long serialVersionUID = 3874989257538664170L;

    private Integer     commentId;      //评论Id

    private Integer     blogs_id;       //被评论博客Id

    private Integer     userId;         //用户Id
    private String      userName;       //用户名称
    private String      headImg;        //用户Id头像

    private String      commentContent; //评论内容
    private Integer     preseCount;     //点赞数
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date        creatTime;      //评论时间

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getBlogs_id() {
        return blogs_id;
    }

    public void setBlogs_id(Integer blogs_id) {
        this.blogs_id = blogs_id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Integer getPreseCount() {
        return preseCount;
    }

    public void setPreseCount(Integer preseCount) {
        this.preseCount = preseCount;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }


    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", blogs_id=" + blogs_id +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", headImg='" + headImg + '\'' +
                ", commentContent='" + commentContent + '\'' +
                ", preseCount=" + preseCount +
                ", creatTime=" + creatTime +
                '}';
    }
}
