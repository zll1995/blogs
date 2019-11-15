package com.jk.comment.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Reply implements Serializable {
    private static final long serialVersionUID = 738361584564755486L;

    private Integer replyId;        //回复Id

    private Integer commentedId;    //被评论Id
    private Integer replyedId;      //被回复Id

    private Integer userId;         //用户Id
    private String userName;        //用户名称
    private String headImg;         //用户Id头像

    private Integer replyuserId;    //被回复用户Id
    private String replyuserName;   //被回复用户名称

    private String replyContent;    //评论内容
    private Integer preseCount;     //点赞数
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date creatTime;         //评论时间

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public Integer getCommentedId() {
        return commentedId;
    }

    public void setCommentedId(Integer commentedId) {
        this.commentedId = commentedId;
    }

    public Integer getReplyedId() {
        return replyedId;
    }

    public void setReplyedId(Integer replyedId) {
        this.replyedId = replyedId;
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

    public Integer getReplyuserId() {
        return replyuserId;
    }

    public void setReplyuserId(Integer replyuserId) {
        this.replyuserId = replyuserId;
    }

    public String getReplyuserName() {
        return replyuserName;
    }

    public void setReplyuserName(String replyuserName) {
        this.replyuserName = replyuserName;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
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
        return "Reply{" +
                "replyId=" + replyId +
                ", commentedId=" + commentedId +
                ", replyedId=" + replyedId +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", headImg='" + headImg + '\'' +
                ", replyuserId=" + replyuserId +
                ", replyuserName='" + replyuserName + '\'' +
                ", replyContent='" + replyContent + '\'' +
                ", preseCount=" + preseCount +
                ", creatTime=" + creatTime +
                '}';
    }
}
