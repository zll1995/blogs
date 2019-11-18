package com.jk.tree.mapper;

import com.jk.tree.model.Tree;

import java.util.List;

/**
 * @ClassName TreeMapper
 * @Description: TODO
 * @Author zjh
 * @Date 2019/11/18 14:48
 * @Version V1.0
 **/
public interface TreeMapper {
    List<Tree> queryTree(int id);
}
