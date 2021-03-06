package com.jk.blogs;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.blogs.model.Adv;
import com.jk.blogs.model.Blogs;
import com.jk.blogs.model.SlideShow;
import com.jk.blogs.service.BlogsService;
import com.jk.comment.model.Comment;
import com.jk.user.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("blogs")
public class BlogsController {
    @Reference(version = "1.0")
    private BlogsService blogsService;
    //每日一句
    @RequestMapping("DailySentence")
    @ResponseBody
    public Map<String, Object> DailySentence(){
       Map<String,Object> map =  blogsService.DailySentence();
       return map;
    }
    //热门推荐
    @RequestMapping("HotBlogs")
    @ResponseBody
    public List<Blogs> HotBlogs(){
       List<Blogs> list =  blogsService.HotBlogs();
       return list;
    }
    //每周热门
    @RequestMapping("WeekHotBlogs")
    @ResponseBody
    public List<Blogs> WeekHotBlogs(){
        List<Blogs> list =  blogsService.WeekHotBlogs();
        return list;
    }
    //轮播图
    @RequestMapping("slideshow")
    @ResponseBody
    public List<Adv> slideShow(){
        List<Adv> list =  blogsService.slideShow();
        return list;
    }

    //博客文章查询
    @RequestMapping("queryzhang")
    public String queryzhang(){

        return "show";
    }

    @RequestMapping("queryzhangAll")
    @ResponseBody
    public Map<String,Object> queryzhangAll(Blogs z, int page, int rows){
        return blogsService.queryzhangAll(z,page,rows);

    }

    //博客文章编辑
    @RequestMapping("toblogs")
    public String toblogs(Blogs z, Model model) {
        z = blogsService.queryblogsById(z.getBlogs_id());

        model.addAttribute("dai", z);
        return "updateblogs";
    }

    @RequestMapping("updateblogs")
    @ResponseBody
    public void updateblogs(Blogs z) {
        blogsService.updateblogs(z);

    }


    //博客文章丢弃传id
    @RequestMapping("updateblogsautus")
    @ResponseBody
    public void updateblogsautus(Integer blogs_id) {
        blogsService.updateblogsautus(blogs_id);

    }


    //回收站查询跳页面
    @RequestMapping("queryhuishou")
    public String queryhuishou(){

        return "huishoushow";
    }
    //回收站查询
    @RequestMapping("queryzhanghui")
    @ResponseBody
    public Map<String,Object> queryzhanghui(Blogs z, int page, int rows){
        return blogsService.queryzhanghui(z,page,rows);

    }
    @RequestMapping("queryBlogsNews")
    @ResponseBody
    public List<Blogs> queryBlogsNews(){
       List<Blogs> list =  blogsService.queryBlogsNews();
       return list;
    }
    //最新评论
    @RequestMapping("NewComment")
    @ResponseBody
    public List<Comment> NewComment(){
        List<Comment> list =blogsService.NewComment();
        return list;
    }
    @RequestMapping("SolrBlogs")
    @ResponseBody
    public Map<String,Object> SolrBlogs(String SearchContent,Integer page,Integer rows){
        Map<String, Object> stringObjectMap = blogsService.SolrBlogs(SearchContent, page, rows);
        return stringObjectMap;
    }
    //按ID查询博客
    @RequestMapping("queryBlogsById")
    @ResponseBody
    public Blogs queryBlogsById(String id){
        Blogs b = blogsService.queryBlogsById(id);
        return b;
    }
    //按ID查用户
    @RequestMapping("queryUserById")
    @ResponseBody
    public User queryUserById(String id){
        User u = blogsService.queryUserById(id);
        return u;
    }

    @RequestMapping("toAddblogs")
    public String toAddblogs() {
        return "addblogs";
    }


    @RequestMapping("addblogs")
    @ResponseBody
    public void addblogs(Blogs z) {
        blogsService.addblogs(z);

    }

}
