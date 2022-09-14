package com.sustech.cloud_storage;


import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DruidDataSourceAutoConfigure.class})
@ComponentScan(basePackages = {"com.sustech"})
public class CloudStorageApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudStorageApplication.class,args);
    }
}
