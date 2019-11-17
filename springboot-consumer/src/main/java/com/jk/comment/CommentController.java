package com.jk.comment;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.comment.model.Comment;
import com.jk.comment.model.Reply;
import com.jk.comment.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CommentController {
    @Reference(version = "1.0")
    private CommentService commentService;

    /**
     * 新增对应博客的评论
     * @param
     * @return
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

    /**
     *新增对应评论的回复
     * @param reply
     * @return
     */
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

    /**
     * 查询对应博客的评论
     * @param page
     * @param rows
     * @param blogs_id
     * @return
     */
    @RequestMapping("queryComment")
    @ResponseBody
    public Map queryComment(Integer page, Integer rows,Integer blogs_id){

        List<Comment> commentList=commentService.queryComment(page,rows,blogs_id);
        Long commentCount=commentService.queryCommentCount(blogs_id);

        Map<String,Object> reCommentmap=new HashMap<>();
        reCommentmap.put("rows",commentList);
        reCommentmap.put("total",commentCount);
        return reCommentmap;
    }

    /**
     *查询对应评论的回复
     * @param page
     * @param rows
     * @param commentedId
     * @return
     */
    @RequestMapping("queryReply")
    @ResponseBody
    public Map queryReply(Integer page, Integer rows,Integer commentedId){
        List<Comment> replyList=commentService.queryReply(page,rows,commentedId);
        Long replyCount=commentService.queryReplyCount(commentedId);

        Map<String,Object> reReplymap=new HashMap<>();

        reReplymap.put("rows",replyList);
        reReplymap.put("total",replyCount);

        return reReplymap;

    }

}
