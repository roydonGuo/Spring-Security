package com.roydon.tokendemo1;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.roydon.tokendemo1.entity.User;
import com.roydon.tokendemo1.mapper.MenuMapper;
import com.roydon.tokendemo1.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class TokenDemo1ApplicationTests {

    @Resource
    private UserMapper userMapper;

    @Resource
    private PasswordEncoder passwordEncoder;

    @Resource
    private MenuMapper menuMapper;

    @Test
    void pwdTest() {
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        // 随机盐加密
        String pwd1 = passwordEncoder.encode("123456");
//        String pwd2 = passwordEncoder.encode("123456");
//        String pwd3 = passwordEncoder.encode("qwer1234");
        System.out.println(pwd1);
//        System.out.println(pwd2);
//        System.out.println(pwd3);
        // 明文密文比较
//        boolean isPwd = passwordEncoder.matches("123456", "$2a$10$AHgfMmOZytlTztxhmAxdIOL1rfl7vTiBryYvlulm83xSRWhydSJB.");
//        System.out.println("isPwd = " + isPwd);

    }


    @Test
    void contextLoads() {

        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUserName, "roydon");
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    @Test
    void mapperTest() {
        List<String> perms = menuMapper.selectPermsByUserId(2L);

        perms.forEach(System.out::println);
    }

}
