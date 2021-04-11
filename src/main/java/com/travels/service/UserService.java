package com.travels.service;

import com.travels.pojo.User;

public interface UserService {
    public User queryById(int id);
    public User queryByName(String name);

}
