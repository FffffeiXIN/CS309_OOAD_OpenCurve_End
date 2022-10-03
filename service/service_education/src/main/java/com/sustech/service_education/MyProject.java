package com.sustech.service_education;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@SpringBootApplication(scanBasePackages = "com.sustech")
@MapperScan("com.sustech.service_education.mapper")
public class MyProject {
    public static void main(String[] args) {
        SpringApplication.run(MyProject.class,args);
    }
}
