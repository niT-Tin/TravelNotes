package com.travels.service;

import com.travels.dao.UserMapper;
import com.travels.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;
    @Override
    public User queryById(int id) {
        return userMapper.queryById(id);
    }

    @Override
    public User queryByName(String name) {
        return userMapper.queryByName(name);
    }

    @Override
    public void insertUser(User user) {
        userMapper.insertUser(user);
    }
}
