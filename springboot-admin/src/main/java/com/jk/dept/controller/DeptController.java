package com.jk.dept.controller;

import com.jk.dept.model.Dept;
import com.jk.dept.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName DeptCONTROLLER
 * @Description: TODO
 * @Author zjh
 * @Date 2019/11/20 14:41
 * @Version V1.0
 **/
@Controller
@RequestMapping("dept")
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping("queryDeptList")
    @ResponseBody
    public List<Dept> queryDeptList() {
        return deptService.queryDeptList();
    }
    @RequestMapping("addDept")
    @ResponseBody
    public void addDept(Dept dept) {
        deptService.addDept(dept);
    }
    @RequestMapping("delDept")
    @ResponseBody
    public void delDept(String  ids) {
        deptService.delDept(ids);
    }
    @RequestMapping("queryDeptById")
    @ResponseBody
    public Dept queryDeptById(Integer  id) {
        return deptService.queryDeptById(id);
    }
    @RequestMapping("updDept")
    @ResponseBody
    public void updDept(Dept dept) {
        deptService.updDept(dept);
    }
}
