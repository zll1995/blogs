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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    @Autowired
    private RedisTemplate redisTemplate;

    public static final String TREE_CACHE_KEY = "tree_cache";
    public static final Long POWERURL_CACHE_TIMEOUT = 30L;

    @Override
    public List<Tree> queryTree(HttpServletRequest request,Integer userId) {
        List list =new ArrayList();
        HttpSession session = request.getSession();
        String id = session.getId();
        String queryTreeCacheKey= TREE_CACHE_KEY+""+id;
        Boolean hasKey = redisTemplate.hasKey(queryTreeCacheKey);
        if(hasKey) {
            System.err.println("=======走缓存=========");
            String string = (String) redisTemplate.opsForValue().get(queryTreeCacheKey);
            list = JSON.parseArray(string);
        }else {
            System.err.println("=======走数据库=======");
            list =queryTree(0,userId);
            for (Object obj : list) {
                redisTemplate.opsForValue().set(queryTreeCacheKey, JSON.toJSONString(list));
            }
        }
        redisTemplate.expire(queryTreeCacheKey,POWERURL_CACHE_TIMEOUT, TimeUnit.MINUTES);
        return list;
    }

    //递归方法
    public List<Tree> queryTree(Integer pid,Integer userId){
        List<Tree> treeList = treeMapper.queryTree(pid,userId);
        for (Tree tree : treeList) {
            List<Tree> nodes = queryTree(tree.getId(),userId);
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

    @Override
    public List<Map<String, Object>> queryRoleTreeList(Integer roleId) {
        // 当前角色已拥有的权限 , 放的全是treeid
        List<Integer> treeIdList = treeMapper.queryTreeByRoleId(roleId);

        List<Map<String, Object>> treeList = roleTreeNodes(0,treeIdList);

        return treeList;
    }

    // 角色赋权限递归
    private List<Map<String, Object>> roleTreeNodes(int pid, List<Integer> treeIdList) {
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("checked", true);
        List<Map<String, Object>> treeList = treeMapper.queryRoleTreeList(pid);
        for (Map<String, Object> map : treeList) {
            for (Integer treeId : treeIdList) {
                if(Integer.valueOf(map.get("value").toString()) == treeId) {
                    map.put("state", map2);
                }
            }
            List<Map<String, Object>> nodes = roleTreeNodes(Integer.parseInt(map.get("value").toString()),treeIdList);
            if(nodes != null && nodes.size() > 0) {
                map.put("nodes", nodes);
                map.put("leaf", true);
                map.put("selectable", false);
            } else {
                map.put("leaf", false);
                map.put("selectable", true);
            }
        }
        return treeList;
    }

    @Override
    public void addRoleTree(Integer roleId, String[] split) {
        treeMapper.deleteRoleTree(roleId);
        treeMapper.addRoleTree(roleId,split);
    }
}
