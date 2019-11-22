package com.jk.blogs.service;

import com.jk.blogs.model.Blogs;
import com.jk.blogs.model.SlideShow;
import com.jk.comment.model.Comment;
import com.jk.user.model.User;

import java.util.List;

import java.util.Map;

public interface BlogsService {
    List<Blogs> HotBlogs();

    Map<String, Object> DailySentence();

    List<Blogs> WeekHotBlogs();

    List<SlideShow> slideShow();

    Map<String, Object> queryzhangAll(Blogs z, int page, int rows);

    Blogs queryblogsById(Integer blogs_id);

    void updateblogs(Blogs z);

    void updateblogsautus(Integer blogs_id);

    Map<String, Object> queryzhanghui(Blogs z, int page, int rows);

    List<Blogs> queryBlogsNews();

    List<Comment> NewComment();

    Map<String, Object> SolrBlogs(String searchContent,Integer page,Integer rows);

    Blogs queryBlogsById(String id);

    User queryUserById(String id);

    Integer queryFansState(String id);

    Integer SetFansState(String id,String state);

    Integer queryBlogsLikeButtonState(String blogsid);

    void updateLikeButtonState(String blogsid, String state);
}
