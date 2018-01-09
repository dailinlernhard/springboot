package com.aixin.service;


import com.aixin.model.Userinfo;

public interface UserInfoService {
    
    /**通过username查找用户信息;*/
    public Userinfo findByUsername(String username);
    
}