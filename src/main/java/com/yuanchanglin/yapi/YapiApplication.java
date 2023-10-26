package com.yuanchanglin.yapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.yuanchanglin.yapi.*.mapper")
@ComponentScan(basePackages = "com.yuanchanglin")
public class YapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(YapiApplication.class, args);
    }

}
