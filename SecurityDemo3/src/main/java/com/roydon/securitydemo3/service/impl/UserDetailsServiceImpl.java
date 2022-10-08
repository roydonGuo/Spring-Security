package com.roydon.securitydemo3.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.roydon.securitydemo3.entity.LoginUser;
import com.roydon.securitydemo3.entity.User;
import com.roydon.securitydemo3.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * Created by Intellij IDEA
 * Author: yi cheng
 * Date: 2022/10/4
 * Time: 15:27
 **/
@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StringUtils.isNotEmpty(username), User::getUserName, username);
        User user = userMapper.selectOne(queryWrapper);

        log.info("查询到数据库用户为：{}",user);

        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        // TODO 查询角色权限

        return new LoginUser(user);
    }
}
