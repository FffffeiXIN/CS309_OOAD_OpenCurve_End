package com.sustech.service_education.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Teacher{
    String id;
    String name;
    String department;
    String password;
    String status;
    Integer failTime =0;
    String online;
    public boolean comparePassword(String password) {
        return password.equals(this.password);
    }
}
