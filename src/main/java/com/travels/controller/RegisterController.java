package com.travels.controller;

import com.travels.pojo.User;
import com.travels.service.UserService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/isHas",method = RequestMethod.GET)
    public String isHas(@RequestParam(value = "userName") String username){
        User user = userService.queryByName(username);
        if (user!=null){
            return "yes";
        }else return "no";
    }
    @RequestMapping(value = "/account",method = RequestMethod.POST)
    public Map<String, Integer> register(User user){
        Map<String, Integer> map=new HashMap<>();
        userService.insertUser(user);
        map.put("status",200);
        return map;
    }
}
