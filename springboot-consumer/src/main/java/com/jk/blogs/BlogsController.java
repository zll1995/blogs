package com.jk.blogs;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jk.blogs.service.BlogsService;
import org.springframework.stereotype.Controller;

@Controller
public class BlogsController {
    @Reference(version = "1.0")
    private BlogsService blogsService;
}
