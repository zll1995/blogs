package com.jk.blogs.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.jk.blogs.mapper.BlogsMapper;
import com.jk.blogs.model.Zhang;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service(version = "1.0")
public class BlogsServiceImpl implements BlogsService{

    @Autowired
    private BlogsMapper blogsMapper;

    @Override
    public Map<String, Object> queryzhangAll(Zhang z, int page, int rows) {
        int sum = blogsMapper.querysum(z);
        int start = (page-1)*rows;
        List<Zhang> userList = blogsMapper.queryzhangAll(z,start,rows);
        Map<String,Object> map = new HashMap<String ,Object>();
        map.put("total",sum);
        map.put("rows",userList);

        return map;
    }
}
