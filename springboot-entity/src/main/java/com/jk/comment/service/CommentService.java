package com.jk.comment.service;

import com.jk.comment.model.Comment;
import com.jk.comment.model.Reply;

public interface CommentService {

    void addComment(Comment comment);

    void addReply(Reply reply);
}
