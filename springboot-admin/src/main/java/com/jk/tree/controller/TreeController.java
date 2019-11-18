package com.jk.tree.controller;

import com.jk.tree.model.Tree;
import com.jk.tree.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName TreeController
 * @Description: TODO
 * @Author zjh
 * @Date 2019/11/18 14:48
 * @Version V1.0
 **/
@Controller
@RequestMapping("tree")
public class TreeController {

    @Autowired
    private TreeService treeService;

    @RequestMapping("queryTree")
    @ResponseBody
    public List<Tree> queryTree(HttpServletRequest request){

        return treeService.queryTree(request);
    }
}
