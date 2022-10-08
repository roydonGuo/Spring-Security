package com.roydon.securitydemo3.service;

import com.roydon.securitydemo3.common.ResponseResult;
import com.roydon.securitydemo3.entity.User;

/**
 * Created by Intellij IDEA
 * Author: yi cheng
 * Date: 2022/10/4
 * Time: 16:10
 **/
public interface LoginService {

    ResponseResult login(User user);

    ResponseResult logout();

}
