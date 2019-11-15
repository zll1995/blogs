package com.jk.blogs.mapper;

import com.jk.blogs.model.Blogs;
import com.jk.blogs.model.SlideShow;

import java.util.List;

public interface BlogsMapper {
    List<Blogs> HotBlogs();

    List<Blogs> WeekHotBlogs();

    List<SlideShow> slideShow();
}
