package com.jk.role.controller;

import com.jk.role.model.Role;
import com.jk.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName RoleController
 * @Description: TODO
 * @Author zjh
 * @Date 2019/11/20 15:41
 * @Version V1.0
 **/
@Controller
@RequestMapping("role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping("queryRoleList")
    @ResponseBody
    public List<Role> queryRoleList(){
        return roleService.queryRoleList();
    }

    @RequestMapping("addRole")
    @ResponseBody
    public void addRole(Role role) {
        roleService.addRole(role);
    }
    @RequestMapping("delRole")
    @ResponseBody
    public void delRole(Integer id) {
        roleService.delRole(id);
    }
    @RequestMapping("queryRoleById")
    @ResponseBody
    public Role queryRoleById(Integer id) {
        return roleService.queryRoleById(id);
    }

}
