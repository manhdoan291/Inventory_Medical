package com.java1906.climan;

import com.java1906.climan.data.model.RoleType;
import com.java1906.climan.data.model.User;
import com.java1906.climan.data.model.UserInfo;
import com.java1906.climan.data.repo.UserInfoRepository;
import com.java1906.climan.data.repo.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ClinicManagementAppTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserInfoRepository userInfoRepository;

    @Test
    void createUsers() {
        User user = new User();
        user.setUsername("casper");
        user.setPassword("123456");
        user.setActiveFlag(true);
        user.setRole(RoleType.ADMIN);

        user = userRepository.save(user);


        UserInfo userInfo = new UserInfo();
        userInfo.setId(user.getId());
        userInfo.setEmail("casper@gmail.com");
        userInfo.setName("Huy");
        userInfo.setPhone("0398902420");

        userInfo = userInfoRepository.save(userInfo);
    }

}
