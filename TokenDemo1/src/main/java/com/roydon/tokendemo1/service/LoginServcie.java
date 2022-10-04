package com.roydon.tokendemo1.service;

import com.roydon.tokendemo1.common.ResponseResult;
import com.roydon.tokendemo1.entity.User;

/**
 * Created by Intellij IDEA
 * Author: yi cheng
 * Date: 2022/10/4
 * Time: 16:10
 **/
public interface LoginServcie {

    ResponseResult login(User user);

    ResponseResult logout();

}
