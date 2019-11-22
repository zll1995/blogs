package com.jk.blogs.mapper;

import com.jk.blogs.model.Blogs;
import com.jk.blogs.model.Fans;
import com.jk.blogs.model.SlideShow;
import com.jk.comment.model.Comment;
import com.jk.user.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogsMapper {
    List<Blogs> HotBlogs();

    List<Blogs> WeekHotBlogs();

    List<SlideShow> slideShow();

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

    Fans queryFansState(@Param("fansid")Integer userid,@Param("starid")String id);

    void deleteFans(@Param("fansid")Integer userid,@Param("starid")String id);

    Fans queryFansAndState(@Param("starid")Integer userid,@Param("fansid")String id);

    void updateFansState(@Param("starid")Integer userid,@Param("fansid")String id,@Param("andid") Integer andid);

    void SetFansState(@Param("fansid")Integer userid,@Param("starid")String id,@Param("andid")Integer andid);

    void updateHeAndId(@Param("starid")Integer userid,@Param("fansid")String id,@Param("sta") int sta);

    Integer queryBlogsLikeButtonState(@Param("u")Integer userid,@Param("b")String blogsid);

    void updateBlogsTableLike(@Param("blogsid")String blogsid,@Param("s")String s);

    void addLikeTableLike(@Param("blogsid")String blogsid,@Param("userid")Integer userid);

    void deleteLikeTableLike(@Param("blogsid")String blogsid,@Param("userid")Integer userid);

    void addBlogsLookById(String id);
}
