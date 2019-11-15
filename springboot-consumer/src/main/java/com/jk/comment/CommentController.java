package com.jk.comment;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.comment.service.CommentService;
import org.springframework.stereotype.Controller;

@Controller
public class CommentController {
    @Reference(version = "1.0")
    private CommentService commentService;
}
