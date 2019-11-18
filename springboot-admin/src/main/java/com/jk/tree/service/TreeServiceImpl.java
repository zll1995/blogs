package com.jk.tree.service;

import com.alibaba.fastjson.JSON;
import com.jk.tree.mapper.TreeMapper;
import com.jk.tree.model.Tree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName TreeServiceImpl4
 * @Description: TODO
 * @Author zjh
 * @Date 2019/11/18 14:49
 * @Version V1.0
 **/
@Service
public class TreeServiceImpl implements TreeService{

    @Autowired
    private TreeMapper treeMapper;

    @Override
    public List<Tree> queryTree(HttpServletRequest request) {
        List list =queryTree(0);
        return list;
    }

    //递归方法
    public List<Tree> queryTree(int pid){
        List<Tree> treeList = treeMapper.queryTree(pid);
        for (Tree tree : treeList) {
            List<Tree> nodes = queryTree(tree.getId());
            if(nodes != null && nodes.size() > 0) {
                tree.setNodes(nodes);
                tree.setLeaf(true);
                tree.setSelectable(false);
            } else {
                tree.setLeaf(false);
                tree.setSelectable(true);
            }

        }
        return treeList;
    }

}
