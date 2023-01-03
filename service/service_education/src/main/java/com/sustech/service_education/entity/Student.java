package com.sustech.service_education.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@Data
public class Student{
    String id;
    String password;
    String name;
    String department;
    String college;
    String grade;
    String status;
    Integer failTime =0;
    String picture_url;
    public boolean comparePassword(String password) {
        return password.equals(this.password);
    }
}
