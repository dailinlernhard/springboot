package com.aixin.service;

import com.aixin.mapper.SyspermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dailin on 2018/1/10.
 */
@Service
public class PermissionService {
    @Autowired
    SyspermissionMapper syspermissionMapper;

    public List<String> getPermissones(String userId){
        return syspermissionMapper.getPermissonByRoleId(userId);
    }
}
