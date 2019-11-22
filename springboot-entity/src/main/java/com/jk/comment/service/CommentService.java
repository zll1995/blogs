package com.jk.comment.service;

import com.jk.comment.model.Comment;
import com.jk.comment.model.Reply;

import java.util.List;

public interface CommentService {

    void addComment(Comment comment);

    void addReply(Reply reply);


    List<Comment> queryComment(Integer page, Integer rows, Integer blogs_id);

    Long queryCommentCount(Integer blogs_id);
    

    List<Comment> queryReply(Integer page, Integer rows, Integer commentedId);

    Long queryReplyCount(Integer commentedId);
}
