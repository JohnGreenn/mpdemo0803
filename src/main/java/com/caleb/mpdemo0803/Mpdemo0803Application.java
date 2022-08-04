package com.caleb.mpdemo0803;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.caleb.mpdemo0803.mapper")
public class Mpdemo0803Application {

    public static void main(String[] args) {
        SpringApplication.run(Mpdemo0803Application.class, args);
    }

}
