package com.jk.dept.service;

import com.jk.dept.mapper.DeptMapper;
import com.jk.dept.model.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName DeptServiceImpl
 * @Description: TODO
 * @Author zjh
 * @Date 2019/11/20 14:43
 * @Version V1.0
 **/
@Service
public class DeptServiceImpl implements DeptService{

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> queryDeptList() {
        return deptMapper.queryDeptList();
    }

    @Override
    public void addDept(Dept dept) {
        deptMapper.addDept(dept);
    }

    @Override
    public void delDept(String ids) {
        deptMapper.delDept(ids);
    }

    @Override
    public Dept queryDeptById(Integer id) {
        return deptMapper.queryDeptById(id);
    }

    @Override
    public void updDept(Dept dept) {
        deptMapper.updDept(dept);
    }
}
