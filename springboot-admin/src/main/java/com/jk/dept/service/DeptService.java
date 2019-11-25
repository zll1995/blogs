package com.jk.dept.service;

import com.jk.dept.model.Dept;

import java.util.List;

/**
 * @ClassName DeptService
 * @Description: TODO
 * @Author zjh
 * @Date 2019/11/20 14:43
 * @Version V1.0
 **/
public interface DeptService {
    List<Dept> queryDeptList();

    void addDept(Dept dept);

    void delDept(String ids);

    Dept queryDeptById(Integer id);

    void updDept(Dept dept);
}
