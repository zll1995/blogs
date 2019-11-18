package com.jk.blogs.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.jk.HttpClient.HttpClient;
import com.jk.blogs.mapper.BlogsMapper;
import com.jk.blogs.model.Blogs;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

import java.util.List;


@Service(version = "1.0")
public class BlogsServiceImpl implements BlogsService{

    @Autowired
    private BlogsMapper blogsMapper;

    @Override
    public List<Blogs> HotBlogs(){
        List<Blogs> list = blogsMapper.HotBlogs();
        return list;
    }

    @Override
    public Map<String, Object> DailySentence() {

        return HttpClient.DailySentence();
    }
}
