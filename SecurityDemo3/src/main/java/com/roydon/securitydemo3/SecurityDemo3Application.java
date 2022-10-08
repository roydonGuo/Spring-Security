package com.roydon.securitydemo3;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@MapperScan("com.roydon.securitydemo3.mapper")
public class SecurityDemo3Application {

    public static void main(String[] args) {
        SpringApplication.run(SecurityDemo3Application.class, args);
        log.info("项目启动中...");
    }

}
