package com.jk.dept.mapper;

import com.jk.dept.model.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName DeptMapper
 * @Description: TODO
 * @Author zjh
 * @Date 2019/11/20 14:50
 * @Version V1.0
 **/
public interface DeptMapper {

    List<Dept> queryDeptList();

    void addDept(Dept dept);

    void delDept(@Param("ids") String ids);

    Dept queryDeptById(Integer id);

    void updDept(Dept dept);
}
