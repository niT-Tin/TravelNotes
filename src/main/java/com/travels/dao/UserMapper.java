package com.travels.dao;

import com.travels.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {
   public User queryById(int id);
   public User queryByName(String name);
}
