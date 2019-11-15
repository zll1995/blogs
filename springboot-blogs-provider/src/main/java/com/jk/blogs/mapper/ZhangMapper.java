package com.jk.blogs.mapper;

import com.jk.blogs.model.Zhang;

public interface ZhangMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Zhang record);

    int insertSelective(Zhang record);

    Zhang selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Zhang record);

    int updateByPrimaryKey(Zhang record);
}