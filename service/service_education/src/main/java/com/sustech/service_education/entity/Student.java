package com.sustech.service_education.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@Data
public class Student{
    Integer id;
    String password;
    String name;
    String department;
    String grade;
    boolean isLock;
    Integer failTime =0;
    public boolean comparePassword(String password) {
        return password.equals(this.password);
    }
}
