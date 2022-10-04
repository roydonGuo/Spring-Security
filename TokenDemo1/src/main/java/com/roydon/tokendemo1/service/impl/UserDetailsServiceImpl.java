package com.roydon.tokendemo1.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.roydon.tokendemo1.entity.LoginUser;
import com.roydon.tokendemo1.entity.User;
import com.roydon.tokendemo1.mapper.MenuMapper;
import com.roydon.tokendemo1.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
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

    @Resource
    private MenuMapper menuMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        // 方法引用
        queryWrapper.eq(StringUtils.isNotEmpty(username),User::getUserName,username);

        User user = userMapper.selectOne(queryWrapper);

        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        // TODO 查询角色权限
//        List<String> permissions = new ArrayList<>(Arrays.asList("test","admin"));
        List<String> permissions = menuMapper.selectPermsByUserId(user.getId());
        log.info("当前登录用户：{}；拥有权限：{}",user.getUserName(),permissions);

        return new LoginUser(user,permissions);
    }
}
