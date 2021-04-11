package com.travels;

import com.travels.pojo.User;
import com.travels.service.UserService;
import com.travels.service.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TravelsNotesApplicationTests {

    @Autowired
    UserServiceImpl userService;
    @Test
    void contextLoads() {
        User user=new User(123,"zeng","12345","12345678900");
        System.out.println(userService.queryById(611211));
        System.out.println(userService.queryByName("root"));
        userService.insertUser(user);
    }

}
