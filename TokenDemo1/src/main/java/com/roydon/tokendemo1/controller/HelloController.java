package com.roydon.tokendemo1.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
