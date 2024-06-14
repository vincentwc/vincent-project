package com.vincent;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wang_cheng
 * @desc TODO
 * @date 2024/6/14 11:43
 */

@MapperScans(value = {@MapperScan("com.vincent.mapper")})
@SpringBootApplication(scanBasePackages = {"com.vincent"})
public class BasicServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasicServiceApplication.class, args);
    }
}
