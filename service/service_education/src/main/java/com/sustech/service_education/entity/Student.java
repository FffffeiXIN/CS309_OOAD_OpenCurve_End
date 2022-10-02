package com.sustech.service_education.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
@Data
public class Student extends AbstractUser{
    Integer id;
    String password;
    String name;
    String department;
    String grade;
    boolean isLock;
    public boolean comparePassword(String password) {
        return password.equals(this.password);
    }
}
