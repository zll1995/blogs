package com.jk.blogs.mapper;

import com.jk.blogs.model.Adv;
import com.jk.blogs.model.Blogs;
import com.jk.blogs.model.SlideShow;
import com.jk.comment.model.Comment;
import com.jk.user.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogsMapper {
    List<Blogs> HotBlogs();

    List<Blogs> WeekHotBlogs();

    List<Adv> slideShow();

    int querysum(Blogs z);

    List<Blogs> queryzhangAll(@Param("z") Blogs z, @Param("sta")int start, @Param("end")int rows);

    Blogs queryblogsById(@Param("pid")Integer blogs_id);

    void updateblogs(@Param("b")Blogs z);

    void updateblogsautus(@Param("pid")Integer blogs_id);

    int querysum1(Blogs z);

    List<Blogs> queryzhanghui(@Param("z") Blogs z, @Param("sta")int start, @Param("end")int rows);

    List<Blogs> queryBlogsNews();

    List<Comment> NewComment();

    Blogs queryBlogsById(String id);

    User queryUserById(String id);

    void addblogs(@Param("b")Blogs z);
}
