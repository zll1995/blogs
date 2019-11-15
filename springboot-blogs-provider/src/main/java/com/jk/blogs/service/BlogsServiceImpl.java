package com.jk.blogs.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.jk.HttpClient.HttpClient;
import com.jk.blogs.mapper.BlogsMapper;
import com.jk.blogs.model.Blogs;
import com.jk.blogs.model.SlideShow;
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

    @Override
    public List<Blogs> WeekHotBlogs() {
        List<Blogs> list = blogsMapper.WeekHotBlogs();
        return list;
    }

    @Override
    public List<SlideShow> slideShow() {
        List<SlideShow> list = blogsMapper.slideShow();
        return list;
    }
}
