package com.sustech.service_education.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Student implements User{
    int id;
    String password;
    String name;
    String department;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public boolean comparePassword(String password) {
        return password.equals(this.password);
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
