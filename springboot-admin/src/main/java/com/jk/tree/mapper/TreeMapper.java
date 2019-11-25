package com.jk.tree.mapper;

import com.jk.tree.model.Tree;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @ClassName TreeMapper
 * @Description: TODO
 * @Author zjh
 * @Date 2019/11/18 14:48
 * @Version V1.0
 **/
public interface TreeMapper {
    List<Tree> queryTree(@Param("pid")Integer pid,@Param("userId")Integer userId);

    List<Map<String, Object>> queryRoleTreeList(int pid);

    List<Integer> queryTreeByRoleId(Integer roleId);

    void deleteRoleTree(Integer roleId);

    void addRoleTree(@Param("roleId")Integer roleId, @Param("split")String[] split);
}
