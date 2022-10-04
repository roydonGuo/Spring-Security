package com.roydon.tokendemo1;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@MapperScan("com.roydon.tokendemo1.mapper")
public class TokenDemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(TokenDemo1Application.class, args);
        log.info("项目启动中...");
    }

}
