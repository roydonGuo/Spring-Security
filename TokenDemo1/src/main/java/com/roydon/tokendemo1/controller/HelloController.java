package com.roydon.tokendemo1.controller;

import com.roydon.tokendemo1.common.ResponseResult;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.roydon.tokendemo1.common.CodeConstants.CODE_200;

/**
 * Created by Intellij IDEA
 * Author: yi cheng
 * Date: 2022/10/3
 * Time: 22:45
 **/
@RestController
public class HelloController {

    /**
     * 权限接口 /hello
     * 所需权限：system:dept:list
     *
     * @return
     */
    @RequestMapping("/hello")
    @PreAuthorize("hasAuthority('system:dept:list')")
    public String hello() {
        return "Hello World~";
    }

    /**
     * 测试跨域
     * @return
     */
    @RequestMapping("/testCors")
    public ResponseResult testCors(){
        return new ResponseResult(CODE_200,"testCors");
    }

}
