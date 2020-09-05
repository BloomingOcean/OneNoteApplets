package com.company.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
@MapperScan({"com.company.project.test.dao","com.company.project.tomato.DAO",
        "com.company.project.noise.DAO" ,"com.company.project.problembook.dao",
        "com.company.project.questionprize.dao","com.company.project.shop.dao",
        "com.company.project.studyhouse.dao","com.company.project.message.dao"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

