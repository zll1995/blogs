package com.jk.blogs;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.blogs.model.Zhang;
import com.jk.blogs.service.BlogsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class BlogsController {
    @Reference(version = "1.0")
    private BlogsService blogsService;


    @RequestMapping("queryzhang")
    public String queryzhang(){

        return "show";
    }
//博客文章查询
    @RequestMapping("queryzhangAll")
    @ResponseBody
    public Map<String,Object> queryzhangAll(Zhang z, int page, int rows){
        return blogsService.queryzhangAll(z,page,rows);

    }

}
