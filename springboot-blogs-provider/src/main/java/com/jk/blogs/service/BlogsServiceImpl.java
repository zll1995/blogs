package com.jk.blogs.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.jk.HttpClient.HttpClient;
import com.jk.blogs.mapper.BlogsMapper;
import com.jk.blogs.model.Blogs;
import com.jk.blogs.model.SlideShow;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
import java.util.HashMap;
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

    @Override
    public Map<String, Object> queryzhangAll(Blogs z, int page, int rows) {
        int sum = blogsMapper.querysum(z);
        int start = (page-1)*rows;
        List<Blogs> userList = blogsMapper.queryzhangAll(z,start,rows);
        Map<String,Object> map = new HashMap<String ,Object>();
        map.put("total",sum);
        map.put("rows",userList);

        return map;
    }

    @Override
    public Blogs queryblogsById(Integer blogs_id) {
        return blogsMapper.queryblogsById(blogs_id);
    }

    @Override
    public void updateblogs(Blogs z) {
        blogsMapper.updateblogs(z);
    }

    @Override
    public void updateblogsautus(Integer blogs_id) {
        blogsMapper.updateblogsautus(blogs_id);
    }

    @Override
    public Map<String, Object> queryzhanghui(Blogs z, int page, int rows) {
        int sum = blogsMapper.querysum1(z);
        int start = (page-1)*rows;
        List<Blogs> userList = blogsMapper.queryzhanghui(z,start,rows);
        Map<String,Object> map = new HashMap<String ,Object>();
        map.put("total",sum);
        map.put("rows",userList);

        return map;
    }

    @Override
    public List<Blogs> queryBlogsNews() {
        return blogsMapper.queryBlogsNews();
    }
}
