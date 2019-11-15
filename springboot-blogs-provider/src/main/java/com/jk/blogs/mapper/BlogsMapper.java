package com.jk.blogs.mapper;

import com.jk.blogs.model.Zhang;

import java.util.List;

public interface BlogsMapper {
    int querysum(Zhang z);

    List<Zhang> queryzhangAll(          Zhang z, int start, int rows);
}
