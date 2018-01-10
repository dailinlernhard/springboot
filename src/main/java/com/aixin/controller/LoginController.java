package com.aixin.controller;

import com.aixin.model.Userinfo;
import com.aixin.service.UserInfoService;
import com.aixin.utils.ShiroKit;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by dailin on 2018/1/10.
 */
@Controller
public class LoginController {
    @Autowired
    UserInfoService userInfoService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(
            @RequestParam(value = "username", required = true) String userName,
            @RequestParam(value = "password", required = true) String password,
            @RequestParam(value = "rememberMe", required = true, defaultValue = "false") boolean rememberMe
    ) {
        Userinfo userinfo = userInfoService.findByUsername(userName);

        logger.info("==========" + userName + password + rememberMe);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(
                userName,
                ShiroKit.md5(password,userinfo.getSalt()));
        token.setRememberMe(rememberMe);

        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
//            rediect.addFlashAttribute("errorText", "您的账号或密码输入错误!");
            return "login";
        }
        return "success";
    }

    @RequestMapping("/")
    public String index() {
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login() {
        return "login";
    }

}
