package com.aixin.service;

import com.aixin.mapper.SysroleMapper;
import com.aixin.mapper.SysuserroleMapper;
import com.aixin.model.Sysrole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dailin on 2018/1/10.
 */
@Service
public class RoleService {
    @Autowired
    SysuserroleMapper sysuserroleMapper;
    public List<String> getRoles(String userName){
        List<String> sysroleList = sysuserroleMapper.getRoleIdsByUserName(userName);

        return sysroleList;
    }
}
