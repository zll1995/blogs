package com.jk.blogs.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.jk.blogs.mapper.BlogsMapper;
import org.springframework.beans.factory.annotation.Autowired;


@Service(version = "1.0")
public class BlogsServiceImpl implements BlogsService{

    @Autowired
    private BlogsMapper blogsMapper;
}
