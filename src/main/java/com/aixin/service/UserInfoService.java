package com.aixin.service;


import com.aixin.mapper.UserinfoMapper;
import com.aixin.model.Userinfo;
import com.aixin.model.UserinfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class UserInfoService {
    
    @Autowired
    private UserinfoMapper userinfoMapper;

    public Userinfo findByUsername(String username) {
       System.out.println("UserInfoServiceImpl.findByUsername()");
       return userinfoMapper.findByUsername(username);
    }

   public List<Userinfo> getMembers(){
       UserinfoExample userinfoExample = new UserinfoExample();
       return userinfoMapper.selectByExample(userinfoExample);
   }
    
}