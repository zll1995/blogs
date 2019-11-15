package com.jk.blogs.service;

import com.jk.blogs.model.Blogs;

import java.util.List;

import java.util.Map;

public interface BlogsService {
    List<Blogs> HotBlogs();

    Map<String, Object> DailySentence();

    List<Blogs> queryBlogsNews();
}
