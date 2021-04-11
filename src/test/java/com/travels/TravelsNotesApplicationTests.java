package com.travels;

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

        System.out.println(userService.queryById(611211));
        System.out.println(userService.queryByName("root"));
    }

}
