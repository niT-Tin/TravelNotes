package com.travels.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //ShiroFilterFactoryBean 3
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(securityManager);
        System.out.println("执行了getShiroFilterFactoryBean方法");

        //添加shiro过滤器
        /*
            anon: 无需认证就可以访问
            authc: 必须认证了才能访问
            user: 必须拥有记住我功能才能访问
            perms: 拥有对某个资源的权限才能访问
            role: 拥有某个角色权限才能访问
        */
        Map<String,String> filterMap=new LinkedHashMap<>();
        //拦截 请求路径
        filterMap.put("/user/*","anon");
        bean.setFilterChainDefinitionMap(filterMap);
        bean.setLoginUrl("/toLogin");       //登录跳转
//        bean.setUnauthorizedUrl("/noauth");  未认证跳转页面
        return bean;
    }
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        System.out.println("执行了getDefaultWebSecurityManager");

        //关联userReaml
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    @Bean
    public UserRealm userRealm(){       //程序启动就执行
        System.out.println("执行了userRealm方法");
        return new UserRealm();
    }
}
