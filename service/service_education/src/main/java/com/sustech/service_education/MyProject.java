package com.sustech.service_education;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableDiscoveryClient
@EnableFeignClients
@EnableSwagger2
@SpringBootApplication
//@ComponentScan(basePackages = {"com.sustech.service_education","com.sustech.commonhandler"})
@MapperScan("com.sustech.service_education.mapper")
public class MyProject {
    public static void main(String[] args) {
        SpringApplication.run(MyProject.class,args);
    }
}
