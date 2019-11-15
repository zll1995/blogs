package com.jk.comment.mapper;

import com.jk.comment.model.Reply;

public interface CommentMapper {
    void addComment();

    void addReply(Reply reply);
}
