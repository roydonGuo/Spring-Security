package com.roydon.securitydemo3;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.roydon.securitydemo3.entity.User;
import com.roydon.securitydemo3.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

@SpringBootTest
class SecurityDemo3ApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Test
    void contextLoads() {

        LambdaQueryWrapper<User> query = new LambdaQueryWrapper<>();
        query.eq(User::getUserName,"roydon");
        query.eq(User::getPassword,"123456");

        User user = userMapper.selectOne(query);

        System.out.println(user+">>>>>>>>>>>>>");

    }

}
