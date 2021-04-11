package com.travels.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/user")        //测试
public class LoginController {

    @RequestMapping({"/","/index"})
    public String index(Model model){
        model.addAttribute("msg","hello,Shiro");
        return "index";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    //shiro 登录
    @RequestMapping("/login")
    public String Login(String userName, String userPassword, Model model){
        //获取当前对象
        Subject subject= SecurityUtils.getSubject();
        //封装用户的登陆数据
        UsernamePasswordToken token = new UsernamePasswordToken(userName,userPassword);
        System.out.println(userName+" "+userPassword);
        try {
            subject.login(token);       //执行登录的方法
            return "index";     //成功跳转接口
        }catch (UnknownAccountException e){
            model.addAttribute("err","用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("err","密码错误");
            return "login";
        }
    }
}
