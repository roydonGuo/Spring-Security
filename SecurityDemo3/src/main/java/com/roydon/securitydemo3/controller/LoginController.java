package com.roydon.securitydemo3.controller;

import com.roydon.securitydemo3.common.ResponseResult;
import com.roydon.securitydemo3.entity.User;
import com.roydon.securitydemo3.service.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Intellij IDEA
 * Author: yi cheng
 * Date: 2022/10/8
 * Time: 11:15
 **/
@RestController
@RequestMapping("/user")
public class LoginController {


    @Resource
    private LoginService loginServcie;

    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user){
        return loginServcie.login(user);
    }


    @RequestMapping("/logout")
    public ResponseResult logout(){
        return loginServcie.logout();
    }


}
