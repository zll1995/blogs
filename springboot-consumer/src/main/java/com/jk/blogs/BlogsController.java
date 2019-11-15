package com.jk.blogs;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.blogs.model.Blogs;
import com.jk.blogs.service.BlogsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BlogsController {
    @Reference(version = "1.0")
    private BlogsService blogsService;


    @RequestMapping("HotBlogs")
    @ResponseBody
    public List<Blogs> HotBlogs(){
       List<Blogs> list =  blogsService.HotBlogs();
       return list;
    }
}
