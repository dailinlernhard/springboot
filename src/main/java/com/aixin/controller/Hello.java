package com.aixin.controller;


import com.aixin.model.Userinfo;
import com.aixin.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.websocket.server.PathParam;

/**
 * Created by dailin on 2018/1/9.
 */
@Controller
public class Hello {
    @Autowired
    private UserInfoService userInfoService;

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
}
