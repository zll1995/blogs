package com.jk.blogs.service;

import com.jk.blogs.model.Zhang;

import java.util.Map;

public interface BlogsService {
    Map<String, Object> queryzhangAll(Zhang z, int page, int rows);
}
