package com.aixin.controller;


import com.aixin.model.Userinfo;
//import com.aixin.service.RoleService;
import com.aixin.service.PermissionService;
import com.aixin.service.RoleService;
import com.aixin.service.UserInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by dailin on 2018/1/9.
 */
@Controller
public class Hello {
    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    RoleService roleService;
    @Autowired
    PermissionService permissionService;

    @RequestMapping("/hello")
    @ResponseBody
    public Userinfo sayHello(){
        Userinfo userInfo = userInfoService.findByUsername("admin");
        return userInfo;
    }


    @RequestMapping("/role/{userName}")
    @ResponseBody
    public List<String> role(@PathVariable(value = "userName") String username){
        List<String> sysroles = roleService.getRoles(username);
        return sysroles;
    }

    @RequestMapping("/permission")
    @ResponseBody
    public List<String> permission(){
        List<String> sysroles = permissionService.getPermissones("1");
        return sysroles;
    }

    @RequestMapping("/listall")
    @ResponseBody
    @RequiresPermissions("userInfo:view")
    public List<Userinfo> list(){
        List<Userinfo> members = userInfoService.getMembers();
        return members;
    }

}
