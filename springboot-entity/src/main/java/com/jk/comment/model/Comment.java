package com.jk.comment.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class Comment implements Serializable {
    private static final long serialVersionUID = 3874989257538664170L;

    private Integer     commentId;      //评论Id

    private Integer     blogs_id;       //被评论博客Id

    private Integer     userId;         //用户Id
    private String      username;       //用户名称
    private String      headImg;        //用户Id头像

    private String      commentContent; //评论内容
    private Integer     preseCount;     //点赞数
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date        creatTime;      //评论时间

    private String      dateTime;       //临时字段，转格式
    private String      blogs_url;       //对应博客连接

    private List<Reply>        replyList;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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



    public List<Reply> getReplyList() {
        return replyList;
    }

    public void setReplyList(List<Reply> replyList) {
        this.replyList = replyList;
    }


    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", blogs_id=" + blogs_id +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", headImg='" + headImg + '\'' +
                ", commentContent='" + commentContent + '\'' +
                ", preseCount=" + preseCount +
                ", creatTime=" + creatTime +
                ", dateTime='" + dateTime + '\'' +
                ", blogs_url='" + blogs_url + '\'' +
                ", replyList=" + replyList +
                '}';
    }

}
