package com.jk.comment.service;
import com.alibaba.dubbo.config.annotation.Service;
import com.jk.comment.mapper.CommentMapper;
import com.jk.comment.model.Comment;
import com.jk.comment.model.Reply;
import org.springframework.beans.factory.annotation.Autowired;

@Service(version = "1.0")
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper  commentMapper;
    @Override
    public void addComment(Comment comment) {
        commentMapper.addComment();
    }

    @Override
    public void addReply(Reply reply) {
        commentMapper.addReply(reply);
    }
}
