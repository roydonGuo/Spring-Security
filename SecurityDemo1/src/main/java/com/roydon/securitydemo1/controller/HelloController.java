package com.roydon.securitydemo1.controller;

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
    @RequestMapping("/hello")
    public String hello(){
        return "Hello World~";
    }

}
