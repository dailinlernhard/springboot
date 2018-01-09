package com.aixin.service;


import com.aixin.mapper.UserinfoMapper;
import com.aixin.model.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserInfoServiceImpl implements UserInfoService{
    
    @Autowired
    private UserinfoMapper userinfoMapper;
    
    @Override
    public Userinfo findByUsername(String username) {
       System.out.println("UserInfoServiceImpl.findByUsername()");
       return userinfoMapper.findByUsername(username);
    }
    
}