package com.aixin.controller;


import com.aixin.mapper.SysroleMapper;
import com.aixin.model.Sysrole;
import com.aixin.model.Userinfo;
//import com.aixin.service.RoleService;
import com.aixin.service.RoleService;
import com.aixin.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;
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

    @RequestMapping("/hello")
    @ResponseBody
    public Userinfo sayHello(){
        Userinfo userInfo = userInfoService.findByUsername("admin");
        return userInfo;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("name", "dailin");

        return "login";
    }

    @RequestMapping("/role/{userName}")
    @ResponseBody
    public List<Sysrole> role(@PathVariable(value = "userName") String username){
        List<Sysrole> sysroles = roleService.getRoles(username);
        return sysroles;
    }

}
