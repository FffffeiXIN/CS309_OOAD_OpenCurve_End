package com.sustech.service_education.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class SuperManager {
    String id = null;
    String name = null;
    String password = null;
    String department;
    String online;
    public boolean comparePassword(String password) {
        return password.equals(this.password);
    }
}

