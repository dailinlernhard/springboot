package com.aixin.config;

import com.aixin.model.Userinfo;
import com.aixin.service.PermissionService;
import com.aixin.service.RoleService;
import com.aixin.service.UserInfoService;
import com.aixin.utils.ShiroKit;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component("aexitShrioRealm")
public class AexitShrioRealm extends AuthorizingRealm {

    @Resource
    UserInfoService userService;
    @Resource
    RoleService roleService;
    @Resource
    PermissionService menuService;

    /**
     * 配置用户权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        if (principals == null) {
            throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
        }

        String userId = (String) getAvailablePrincipal(principals);
        List<String> roleList = roleService.getRoles(userId);

        //用户角色获取用户功能id
        Set<String> roleSet = new HashSet<>();  //角色集合
        Set<String> menuSet = new HashSet<>();  //菜单集合

        List<String> menus;
        for(String roleId : roleList){
            roleSet.add(roleId);
            menus = menuService.getPermissones(roleId);
            Collections.addAll(menuSet,menus.toArray(new String[menus.size()]));
        }

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo(roleSet);
        authorizationInfo.setStringPermissions(menuSet);

        return authorizationInfo;
    }


    /**
     * 配置登录认证信息
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userId = token.getUsername();
        if (userId == null) {
            throw new AccountException("Null usernames are not allowed by this realm.");
        }

        //查出是否有此用户
        Userinfo curUser = userService.findByUsername(userId);
        if(curUser == null)
            throw new AccountException("account error:one user name must have one and only one user! ");

        //密码加密
        String password = ShiroKit.md5(curUser.getPassword(),curUser.getSalt());

        return new SimpleAuthenticationInfo(userId, password, getName());

    }
}