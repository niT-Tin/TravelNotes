package com.travels.config;

import com.travels.pojo.User;
import com.travels.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行了=>授权doGetAuthorizationInfo");

        //授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //   info.addStringPermission("user:add");   //给通过的用户授权 add

        //拿到当前登录的这个对象
//        Subject subject = SecurityUtils.getSubject();
        //获取用户对象
//        User user = (User) subject.getPrincipal();
        //从数据库中取得这个User得权限 并设置
//        info.addStringPermission(user.getPerms());
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //连接真实数据库
        UsernamePasswordToken token=(UsernamePasswordToken)authenticationToken;
        User user = userService.queryByName(token.getUsername());
        System.out.println("执行了=>认证doGetAuthenticationInfo");
        System.out.println(user);
//        String username=user.getUsername();
//                String password=user.getPassword();
        if (user==null) return null;
        //密码认证shiro做        加密~
        return new SimpleAuthenticationInfo(user,user.getUserPassword(),"");
    }
}
