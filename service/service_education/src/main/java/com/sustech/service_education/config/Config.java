package com.sustech.service_education.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(value = "com.sustech.service_education.mapper")
public class Config {
}
