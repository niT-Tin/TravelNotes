package com.travels.controller;

import com.travels.pojo.User;
import com.travels.service.UserService;
import com.travels.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")        //测试  用户登录
public class LoginController {
    @Autowired
    UserServiceImpl userService;
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    // 登录
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Map<String, String> Login(String userName, String userPassword, HttpServletRequest request){
        User user = userService.queryByName(userName);
        if (user!=null&&user.getUserPassword().equals(userPassword)){
                String token= UUID.randomUUID().toString();
                Map<String,String> map=new HashMap<>();
                request.getSession().setAttribute("token",token);
                map.put("token",token);
                map.put("status","200");
                return map;
        }else return null;
    }
}
