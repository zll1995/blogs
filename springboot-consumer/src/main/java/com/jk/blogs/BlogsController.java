package com.jk.blogs;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.blogs.model.Blogs;
import com.jk.blogs.model.SlideShow;
import com.jk.blogs.service.BlogsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public List<SlideShow> slideShow(){
        List<SlideShow> list =  blogsService.slideShow();
        return list;
    }
}
