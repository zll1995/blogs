package com.jk.comment;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.comment.model.Comment;
import com.jk.comment.model.Reply;
import com.jk.comment.service.CommentService;
import com.sun.javafx.collections.MappingChange;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class CommentController {
    @Reference(version = "1.0")
    private CommentService commentService;

    /**
     *
     */
    @RequestMapping("addComment")
    @ResponseBody
    public Map<String, Object> addComment(Comment comment){
        Map<String,Object> readdCommentmap=new HashMap<>();
        try {
            comment.setPreseCount(0);
            comment.setCreatTime(new Date());
            commentService.addComment(comment);

            readdCommentmap.put("flag","评论成功");
            return readdCommentmap;
        }catch (Exception e){
            e.printStackTrace();
        }
        readdCommentmap.put("flag","评论失败");
        return readdCommentmap;
    }

    @RequestMapping("addReply")
    @ResponseBody
    public Map<String,Object> addReply(Reply reply){
        Map<String,Object> readdReplymap=new HashMap<>();
        try {

            reply.setPreseCount(0);
            reply.setCreatTime(new Date());
            commentService.addReply(reply);

            readdReplymap.put("flag","回复成功");
            return readdReplymap;
        }catch (Exception e){
            e.printStackTrace();
        }
        readdReplymap.put("flag","回复失败");
        return readdReplymap;
    }




}
