package com.vulcan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.vulcan.*.mapper")
@SpringBootApplication
public class VulcanApplication {
    public static void main(String[] args) {
        SpringApplication.run(VulcanApplication.class,args);
    }
}
