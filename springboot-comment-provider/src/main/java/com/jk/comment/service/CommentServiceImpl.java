package com.jk.comment.service;
import com.alibaba.dubbo.config.annotation.Service;
import com.jk.comment.mapper.CommentMapper;
import com.jk.comment.model.Comment;
import com.jk.comment.model.Reply;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service(version = "1.0")
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper  commentMapper;
    @Override
    public void addComment(Comment comment) {
        commentMapper.addComment(comment);
    }

    @Override
    public void addReply(Reply reply) {
        commentMapper.addReply(reply);
    }

    @Override
    public List<Comment> queryComment(Integer page, Integer rows, Integer blogs_id) {
        Integer startNum=(page-1)*rows;
        return commentMapper.queryComment(startNum,rows,blogs_id);
    }

    @Override
    public Long queryCommentCount(Integer blogs_id) {
        return commentMapper.queryCommentCount(blogs_id);
    }

    @Override
    public List<Reply> queryReply(Integer commentedId) {
        return commentMapper.queryReply(commentedId);
    }

}
