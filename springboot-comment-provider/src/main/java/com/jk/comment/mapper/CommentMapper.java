package com.jk.comment.mapper;

import com.jk.comment.model.Comment;
import com.jk.comment.model.Reply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {
    void addComment(Comment comment);

    void addReply(Reply reply);



    List<Comment> queryComment(@Param("startNum") Integer startNum,@Param("rows") Integer rows,@Param("blogs_id") Integer blogs_id);

    Long queryCommentCount(@Param("blogs_id")Integer blogs_id);

    

    List<Reply> queryReply(@Param("commentedId") Integer commentedId);

}
