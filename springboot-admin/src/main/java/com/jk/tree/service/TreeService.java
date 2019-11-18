package com.jk.tree.service;

import com.jk.tree.model.Tree;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName TreeService
 * @Description: TODO
 * @Author zjh
 * @Date 2019/11/18 14:48
 * @Version V1.0
 **/
public interface TreeService {
    List<Tree> queryTree(HttpServletRequest request);
}
