package com.example.kody;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example")
public class KodyApplication {

    public static void main(String[] args) {
        SpringApplication.run(KodyApplication.class, args);
    }

}
