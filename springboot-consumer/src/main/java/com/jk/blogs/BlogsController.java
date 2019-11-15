package com.jk.blogs;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.blogs.service.BlogsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("blogs")
public class BlogsController {
    @Reference(version = "1.0")
    private BlogsService blogsService;

    @RequestMapping("DailySentence")
    @ResponseBody
    public Map<String, Object> DailySentence(){
       Map<String,Object> map =  blogsService.DailySentence();
       return map;
    }
}
